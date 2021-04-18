package org.souzarodrigo.modules.security.resources;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.souzarodrigo.global.shared.security.dto.UserCreatedDTO;
import org.souzarodrigo.global.shared.security.dto.UserLoginDTO;
import org.souzarodrigo.global.shared.security.dto.UserTokenDTO;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@ApplicationScoped
@Path("/authentication")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Authentication", description = "Login and register user in application")
@SecurityScheme(securitySchemeName = "jwt", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "jwt")
public interface ISecurityResource {

    @POST
    @PermitAll
    @Transactional
    @Path("sign-up")
    @Operation(summary = "Sign up user", description = "")
    Response signUp(UserCreatedDTO user);

    @POST
    @PermitAll
    @Path("sign-in/customer")
    @Operation(summary = "Login Customer", description = "")
    UserTokenDTO loginCustomer(UserLoginDTO userLoginDTO);

    @POST
    @PermitAll
    @Path("sign-in/shopkeeper")
    @Operation(summary = "Login Shopkeeper", description = "")
    UserTokenDTO loginShopkeeper(UserLoginDTO userLoginDTO);

    @POST
    @PermitAll
    @Path("sign-in/admin")
    @Operation(summary = "Login Admin", description = "")
    UserTokenDTO loginAdmin(UserLoginDTO userLoginDTO);
}
