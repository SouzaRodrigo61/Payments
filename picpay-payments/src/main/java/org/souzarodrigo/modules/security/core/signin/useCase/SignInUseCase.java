package org.souzarodrigo.modules.security.core.signin.useCase;

import org.souzarodrigo.modules.security.repositories.ISecurityRepository;
import org.souzarodrigo.global.shared.security.dto.UserLoginDTO;
import org.souzarodrigo.global.shared.security.dto.UserTokenDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class SignInUseCase {

    @Inject
    ISecurityRepository userRepository;


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
