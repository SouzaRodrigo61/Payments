package org.souzarodrigo.modules.security.core.register.controller;

import org.souzarodrigo.modules.security.core.register.useCase.RegisterUseCase;
import org.souzarodrigo.core.models.Admin;
import org.souzarodrigo.core.models.Customer;
import org.souzarodrigo.core.models.Shopkeeper;
import org.souzarodrigo.core.utils.models.security.dto.UserCreatedDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@RequestScoped
public class RegisterController {

    @Inject
    RegisterUseCase registerUseCase;

    public Response handle(UserCreatedDTO userCreatedDTO) {

        switch (userCreatedDTO.role) {
            case ADMIN:
                Admin admin = handleAdmin(userCreatedDTO);
                return Response.status(Response.Status.CREATED).entity(admin).build();
            case CUSTOMER:
                Customer customer = handleCustomer(userCreatedDTO);
                return Response.status(Response.Status.CREATED).entity(customer).build();
            case SHOPKEEPER:
                Shopkeeper shopkeeper = handleShopkeeper(userCreatedDTO);
                return Response.status(Response.Status.CREATED).entity(shopkeeper).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    /**
     *
     * @param userCreatedDTO UserCreatedDTO
     * @return Admin
     */
    private Admin handleAdmin(UserCreatedDTO userCreatedDTO) {
        return registerUseCase.executeAdmin(userCreatedDTO);
    }

    /**
     *
     * @param userCreatedDTO UserCreatedDTO
     * @return Customer
     */
    private Customer handleCustomer(UserCreatedDTO userCreatedDTO) {
        return registerUseCase.executeCustomer(userCreatedDTO);
    }

    /**
     *
     * @param userCreatedDTO UserCreatedDTO
     * @return Shopkeeper
     */
    private Shopkeeper handleShopkeeper(UserCreatedDTO userCreatedDTO) {
        return registerUseCase.executeShopkeeper(userCreatedDTO);
    }
}
