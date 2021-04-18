package org.souzarodrigo.modules.user.core.delete.useCase;

import org.souzarodrigo.global.models.Customer;
import org.souzarodrigo.global.models.Shopkeeper;
import org.souzarodrigo.modules.user.repository.IUserRepository;
import org.souzarodrigo.core.utils.security.constants.Roles;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
public class DeleteUserUseCase {

    @Inject
    IUserRepository userRepository;

    public void execute(SecurityContext context, Roles role) {

        switch (role) {
            case SHOPKEEPER:
                Shopkeeper shopkeeper = userRepository.findByEmailShopkeeper(context.getUserPrincipal().getName());
                shopkeeper.delete();
            case CUSTOMER:
                Customer customer = userRepository.findByEmailCustomer(context.getUserPrincipal().getName());
                customer.delete();
        }
    }
}
