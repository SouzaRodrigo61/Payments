package org.souzarodrigo.modules.security.resources.impl;

import org.souzarodrigo.modules.security.core.register.controller.RegisterController;
import org.souzarodrigo.modules.security.core.signin.controller.SignInController;
import org.souzarodrigo.utils.models.security.dto.UserCreatedDTO;
import org.souzarodrigo.utils.models.security.dto.UserLoginDTO;
import org.souzarodrigo.utils.models.security.dto.UserTokenDTO;
import org.souzarodrigo.modules.security.resources.ISecurityResource;

import javax.inject.Inject;
import javax.ws.rs.core.Response;


public class SecurityResource implements ISecurityResource {

    @Inject
    RegisterController registerController;

    @Inject
    SignInController signInController;

    @Override
    public Response signUp(UserCreatedDTO user) {
        return registerController.handle(user);
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
