package org.souzarodrigo.modules.user.resource;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.souzarodrigo.global.shared.users.dto.UserUpdateDTO;

import javax.annotation.Priority;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Priorities;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@ApplicationScoped
@Path("/user")
@Priority(Priorities.AUTHENTICATION)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "User", description = "Work with user in application")
@SecurityScheme(securitySchemeName = "jwt", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "jwt")
public interface IUserResource {


    @GET
    @SecurityRequirement(name="jwt", scopes = {})
    @RolesAllowed({"ADMIN", "CUSTOMER", "SHOPKEEPER"})
    @Operation(summary = "Get all data about user logged", description = "Returns all user data by function ")
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
            ),
            @APIResponse(
                    responseCode = "401",
                    description = "Unauthorized"
            ),
            @APIResponse(
                    responseCode = "403",
                    description = "Forbidden"
            ),
            @APIResponse(
                    responseCode = "500",
                    description = "The server encountered a situation that it does not know how to deal with."
            )
        }
    )
    Response findUser(@Context SecurityContext ctx);

    @PUT
    @SecurityRequirement(name="jwt", scopes = {})
    @RolesAllowed({"CUSTOMER", "SHOPKEEPER"})
    @Operation(summary = "Update data of user logged", description = "Updated Data ")
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
            ),
            @APIResponse(
                    responseCode = "401",
                    description = "Unauthorized"
            ),
            @APIResponse(
                    responseCode = "403",
                    description = "Forbidden"
            ),
            @APIResponse(
                    responseCode = "500",
                    description = "The server encountered a situation that it does not know how to deal with."
            )
        }
    )
    Response updateUserData(@Context SecurityContext ctx, UserUpdateDTO userUpdateDTO);

    @DELETE
    @SecurityRequirement(name="jwt", scopes = {})
    @RolesAllowed({"ADMIN", "CUSTOMER", "SHOPKEEPER"})
    @Operation(summary = "Deleted data of user logged", description = "Deleted Data ")
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
            ),
            @APIResponse(
                    responseCode = "401",
                    description = "Unauthorized"
            ),
            @APIResponse(
                    responseCode = "403",
                    description = "Forbidden"
            ),
            @APIResponse(
                    responseCode = "500",
                    description = "The server encountered a situation that it does not know how to deal with."
            )
        }
    )
    Response deleteUserData(@Context SecurityContext ctx);
}
