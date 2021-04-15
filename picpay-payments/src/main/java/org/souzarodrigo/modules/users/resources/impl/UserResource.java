package org.souzarodrigo.modules.users.resources.impl;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jose4j.jwt.JwtClaims;
import org.souzarodrigo.modules.users.core.find.controller.FindUserController;
import org.souzarodrigo.modules.users.core.register.controller.RegisterController;
import org.souzarodrigo.modules.users.core.signin.controller.SignInController;
import org.souzarodrigo.modules.users.models.Admin;
import org.souzarodrigo.modules.users.models.Shopkeeper;
import org.souzarodrigo.utils.models.users.dto.UserCreatedDTO;
import org.souzarodrigo.utils.models.users.dto.UserLoginDTO;
import org.souzarodrigo.utils.models.users.dto.UserTokenDTO;
import org.souzarodrigo.modules.users.models.Customer;
import org.souzarodrigo.modules.users.resources.IUserResource;
import org.souzarodrigo.utils.security.constants.Roles;

import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.HashMap;
import java.util.Map;


public class UserResource implements IUserResource {

    @Inject
    RegisterController registerController;

    @Inject
    SignInController signInController;

    @Inject
    FindUserController findUserController;

    @Inject
    JsonWebToken jwt;

    @Override
    public Response findUser(@Context SecurityContext context) {
        return findUserController.handleFindUser(context);
    }

    private String getResponseString(SecurityContext ctx) {
        String name;
        if (ctx.getUserPrincipal() == null) {
            name = "anonymous";
        } else if (!ctx.getUserPrincipal().getName().equals(jwt.getName())) {
            throw new InternalServerErrorException("Principal and JsonWebToken names do not match");
        } else {
            name = ctx.getUserPrincipal().getName();
        }
        return String.format("email: %s,"
                        + " isHttps: %s,"
                        + " authScheme: %s,"
                        + " hasJWT: %s",
                name, ctx.isSecure(), ctx.getAuthenticationScheme(), hasJwt());
    }

    private boolean hasJwt() {
        return jwt.getClaimNames() != null;
    }

    @Override
    public Response signUp(UserCreatedDTO user) {

        switch (user.role) {
            case ADMIN:
                Admin admin = registerController.handleAdmin(user);
                return Response.status(Response.Status.CREATED).entity(admin).build();
            case CUSTOMER:
                Customer customer = registerController.handleCustomer(user);
                return Response.status(Response.Status.CREATED).entity(customer).build();
            case SHOPKEEPER:
                Shopkeeper shopkeeper = registerController.handleShopkeeper(user);
                return Response.status(Response.Status.CREATED).entity(shopkeeper).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @Override
    public UserTokenDTO loginCustomer(UserLoginDTO userLoginDTO) {
        return signInController.executeCustomer(userLoginDTO);
    }

    @Override
    public UserTokenDTO loginShopkeeper(UserLoginDTO userLoginDTO) {
        return signInController.executeShopkeeper(userLoginDTO);
    }

    @Override
    public UserTokenDTO loginAdmin(UserLoginDTO userLoginDTO) {
        return signInController.executeAdmin(userLoginDTO);
    }
}
