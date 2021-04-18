package org.souzarodrigo.modules.user.resource.impl;

import org.souzarodrigo.modules.user.core.delete.controller.DeleteUserController;
import org.souzarodrigo.modules.user.core.find.controller.FindUserController;
import org.souzarodrigo.modules.user.core.update.controller.UpdateController;
import org.souzarodrigo.modules.user.resource.IUserResource;
import org.souzarodrigo.global.shared.users.dto.UserUpdateDTO;

import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public class UserResource implements IUserResource {

    @Inject
    FindUserController findUserController;

    @Inject
    UpdateController updateController;

    @Inject
    DeleteUserController deleteUserController;

    @Override
    public Response findUser(@Context SecurityContext ctx) {
        return findUserController.handleFindUser(ctx);
    }

    @Override
    public Response updateUserData(@Context SecurityContext ctx, UserUpdateDTO userUpdateDTO) {
        return updateController.handle(ctx, userUpdateDTO);
    }

    @Override
    public Response deleteUserData(@Context SecurityContext ctx) {
        return deleteUserController.handle(ctx);
    }
}
