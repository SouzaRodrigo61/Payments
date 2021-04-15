package org.souzarodrigo.modules.users.core.find.controller;

import org.souzarodrigo.modules.users.core.find.useCase.FindUserUseCase;
import org.souzarodrigo.modules.users.models.Admin;
import org.souzarodrigo.modules.users.models.Customer;
import org.souzarodrigo.modules.users.models.Shopkeeper;
import org.souzarodrigo.utils.security.constants.Roles;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
public class FindUserController {

    @Inject
    FindUserUseCase findUserUseCase;

    public Response handleFindUser(SecurityContext context) {

        Object user = null;

        if (context.isUserInRole(String.valueOf(Roles.ADMIN))) {
            user = findUserUseCase.executeFindUser(context, Roles.ADMIN, Admin.class);
        }
        if (context.isUserInRole(String.valueOf(Roles.CUSTOMER))) {
            user = findUserUseCase.executeFindUser(context, Roles.CUSTOMER, Customer.class);
        }
        if (context.isUserInRole(String.valueOf(Roles.SHOPKEEPER))) {
            user = findUserUseCase.executeFindUser(context, Roles.SHOPKEEPER, Shopkeeper.class);
        }

        return Response.status(200).entity(user).build();
    }
}
