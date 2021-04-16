package org.souzarodrigo.modules.user.core.update.useCase;

import org.souzarodrigo.core.models.Customer;
import org.souzarodrigo.core.models.Shopkeeper;
import org.souzarodrigo.modules.user.repository.IUserRepository;
import org.souzarodrigo.core.utils.models.users.dto.UserUpdateDTO;
import org.souzarodrigo.core.utils.security.constants.Roles;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
public class UpdateUserUseCase {


    @Inject
    IUserRepository userRepository;

    public <T> T execute(SecurityContext context, UserUpdateDTO userUpdateDTO, Roles role, Class<T> targetClass) {

        switch (role) {
            case SHOPKEEPER:
                Shopkeeper shopkeeper = userRepository.findByEmailShopkeeper(context.getUserPrincipal().getName());
                shopkeeper.setNumberTransactions(userUpdateDTO.numberTransactions);
                shopkeeper.setBankBalance(userUpdateDTO.shopkeeper.getBankBalance());
                shopkeeper.setBankData(userUpdateDTO.shopkeeper.getBankData());

                shopkeeper.update();
                return targetClass.cast(shopkeeper);
            case CUSTOMER:
                Customer customer = userRepository.findByEmailCustomer(context.getUserPrincipal().getName());

                customer.setCard(userUpdateDTO.customer.getCard());
                customer.setNumberTransactions(userUpdateDTO.numberTransactions);

                customer.update();
                return targetClass.cast(customer);
        }

        return targetClass.cast(null);
    }
}
