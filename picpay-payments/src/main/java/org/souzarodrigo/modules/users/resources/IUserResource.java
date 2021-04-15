package org.souzarodrigo.modules.users.resources;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.souzarodrigo.utils.models.users.dto.UserCreatedDTO;
import org.souzarodrigo.utils.models.users.dto.UserLoginDTO;
import org.souzarodrigo.utils.models.users.dto.UserTokenDTO;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


@ApplicationScoped
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "User", description = "Login and register user in application")
@SecurityScheme(securitySchemeName = "jwt", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "jwt")
public interface IUserResource {

    @GET
    @Path("user")
    @RolesAllowed({"ADMIN", "CUSTOMER", "SHOPKEEPER"})
    @Operation(summary = "User", description = "list all customer in application")
    @APIResponses(
        value = {
            @APIResponse(
                responseCode = "200",
                description = "Response OK",
                content = @Content(mediaType = MediaType.APPLICATION_JSON)
            ),
            @APIResponse(
                    responseCode = "400",
                    description = "Error in application"
            )
        }
    )
    @SecurityRequirement(name="jwt", scopes = {})
    public Response findUser(@Context SecurityContext ctx);

    @POST
    @PermitAll
    @Path("sign-up")
    @Transactional
    public Response signUp(UserCreatedDTO user);

    @POST
    @PermitAll
    @Path("sign-in/customer")
    public UserTokenDTO loginCustomer(UserLoginDTO userLoginDTO);

    @POST
    @PermitAll
    @Path("sign-in/shopkeeper")
    public UserTokenDTO loginShopkeeper(UserLoginDTO userLoginDTO);

    @POST
    @PermitAll
    @Path("sign-in/admin")
    public UserTokenDTO loginAdmin(UserLoginDTO userLoginDTO);
}
