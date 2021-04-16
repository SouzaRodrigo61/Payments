package org.souzarodrigo.modules.user.core.delete.controller;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.souzarodrigo.modules.user.core.delete.useCase.DeleteUserUseCase;
import org.souzarodrigo.core.utils.security.constants.Roles;
import org.souzarodrigo.core.utils.security.services.RoleService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
public class DeleteUserController {

    @Inject
    DeleteUserUseCase deleteUserUseCase;

    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    RoleService roleService;

    public Response handle(SecurityContext context) {

        if (context.getUserPrincipal() != null) {
            Roles role = roleService.getRoles(jsonWebToken);

            switch (role) {
                case SHOPKEEPER:
                case CUSTOMER:
                    deleteUserUseCase.execute(context, role);
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
