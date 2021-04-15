package org.souzarodrigo.modules.users.core.register.controller;

import org.souzarodrigo.modules.users.core.register.useCase.RegisterUseCase;
import org.souzarodrigo.modules.users.models.Admin;
import org.souzarodrigo.modules.users.models.Customer;
import org.souzarodrigo.modules.users.models.Shopkeeper;
import org.souzarodrigo.utils.models.users.dto.UserCreatedDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class RegisterController {

    @Inject
    RegisterUseCase registerUseCase;

    /**
     *
     * @param userCreatedDTO
     * @return Admin
     */
    public Admin handleAdmin(UserCreatedDTO userCreatedDTO) {
        return registerUseCase.executeAdmin(userCreatedDTO);
    }

    /**
     *
     * @param userCreatedDTO
     * @return Customer
     */
    public Customer handleCustomer(UserCreatedDTO userCreatedDTO) {
        return registerUseCase.executeCustomer(userCreatedDTO);
    }

    /**
     *
     * @param userCreatedDTO
     * @return Shopkeeper
     */
    public Shopkeeper handleShopkeeper(UserCreatedDTO userCreatedDTO) {
        return registerUseCase.executeShopkeeper(userCreatedDTO);
    }
}
