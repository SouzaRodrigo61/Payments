package org.souzarodrigo.modules.users.core.signin.controller;

import org.souzarodrigo.modules.users.core.signin.useCase.SignInUseCase;
import org.souzarodrigo.utils.models.users.dto.UserLoginDTO;
import org.souzarodrigo.utils.models.users.dto.UserTokenDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class SignInController {

    @Inject
    SignInUseCase signInUseCase;

    public UserTokenDTO executeCustomer(UserLoginDTO userLoginDTO) {
        return signInUseCase.handleCustomer(userLoginDTO);
    }

    public UserTokenDTO executeShopkeeper(UserLoginDTO userLoginDTO) {
        return signInUseCase.handleShopkeeper(userLoginDTO);
    }

    public UserTokenDTO executeAdmin(UserLoginDTO userLoginDTO) {
        return signInUseCase.handleAdmin(userLoginDTO);
    }
}
