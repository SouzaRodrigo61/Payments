package org.souzarodrigo.modules.users.core.register.useCase;

import org.souzarodrigo.modules.users.models.Admin;
import org.souzarodrigo.modules.users.models.Customer;
import org.souzarodrigo.modules.users.models.Shopkeeper;
import org.souzarodrigo.modules.users.repositories.IUserRepository;
import org.souzarodrigo.utils.models.users.User;
import org.souzarodrigo.utils.models.users.dto.UserCreatedDTO;
import org.souzarodrigo.utils.security.util.EncryptPassword;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class RegisterUseCase {

    @Inject
    IUserRepository userRepository;

    /**
     * 
     * @param userCreatedDTO
     * @return Admin
     */
    public Admin executeAdmin(UserCreatedDTO userCreatedDTO) {
        Admin user = new Admin();

        createUser(userCreatedDTO, user);

        userRepository.create(user);
        return user;

    }

    /**
     * 
     * @param userCreatedDTO
     * @return Customer
     */
    public Customer executeCustomer(UserCreatedDTO userCreatedDTO) {
        Customer user = new Customer();

        createUser(userCreatedDTO, user);

        userRepository.create(user);
        return user;
    }

    /**
     *
     * @param userCreatedDTO
     * @return Shopkeeper
     */
    public Shopkeeper executeShopkeeper(UserCreatedDTO userCreatedDTO) {
        Shopkeeper user = new Shopkeeper();

        createUser(userCreatedDTO, user);

        userRepository.create(user);
        return user;
    }

    private <T extends User> void createUser(UserCreatedDTO userCreatedDTO, T user) {

        user.setRole(userCreatedDTO.role);
        user.setEmail(userCreatedDTO.email);
        user.setName(userCreatedDTO.name);
        user.setPhone(userCreatedDTO.phone);
        user.setPassword(EncryptPassword.getEncryptPassword(userCreatedDTO.password));

    }

}
