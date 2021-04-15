package org.souzarodrigo.modules.users.core.signin.useCase;

import org.souzarodrigo.modules.users.repositories.IUserRepository;
import org.souzarodrigo.utils.models.users.dto.UserLoginDTO;
import org.souzarodrigo.utils.models.users.dto.UserTokenDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class SignInUseCase {

    @Inject
    IUserRepository userRepository;


    public UserTokenDTO handleCustomer(UserLoginDTO userLoginDTO) {
        return userRepository.loginCustomer(userLoginDTO);
    }

    public UserTokenDTO handleShopkeeper(UserLoginDTO userLoginDTO) {
        return userRepository.loginShopkeeper(userLoginDTO);
    }

    public UserTokenDTO handleAdmin(UserLoginDTO userLoginDTO) {
        return userRepository.loginAdmin(userLoginDTO);
    }
}
