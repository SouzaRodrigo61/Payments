package org.souzarodrigo.modules.user.core.update.controller;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.souzarodrigo.modules.user.core.update.useCase.UpdateUserUseCase;
import org.souzarodrigo.modules.user.models.Admin;
import org.souzarodrigo.modules.user.models.Customer;
import org.souzarodrigo.modules.user.models.Shopkeeper;
import org.souzarodrigo.utils.models.users.dto.UserUpdateDTO;
import org.souzarodrigo.utils.security.constants.Roles;
import org.souzarodrigo.utils.security.services.RoleService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
public class UpdateController {

    @Inject
    UpdateUserUseCase updateUserUseCase;

    @Inject
    JsonWebToken jwt;

    @Inject
    RoleService roleService;

    public Response handle(SecurityContext context, UserUpdateDTO userUpdateDTO) {

        if (context.getUserPrincipal() != null) {
            Roles role = roleService.getRoles(jwt);
            switch (role) {
                case SHOPKEEPER:
                    updateUserUseCase.execute(context, userUpdateDTO, role, Shopkeeper.class);
                    break;
                case CUSTOMER:
                    updateUserUseCase.execute(context, userUpdateDTO, role, Customer.class);
                    break;
                default:
                    return Response.status(Response.Status.FORBIDDEN).build();
            }

            return Response.status(200).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

    }
}
