package org.souzarodrigo.modules.security.core.register.useCase;

import org.souzarodrigo.modules.user.models.Admin;
import org.souzarodrigo.modules.user.models.Customer;
import org.souzarodrigo.modules.user.models.Shopkeeper;
import org.souzarodrigo.modules.security.repositories.ISecurityRepository;
import org.souzarodrigo.utils.models.users.User;
import org.souzarodrigo.utils.models.security.dto.UserCreatedDTO;
import org.souzarodrigo.utils.security.util.EncryptPassword;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class RegisterUseCase {

    @Inject
    ISecurityRepository userRepository;

    /**
     *
     * @param userCreatedDTO UserCreatedDTO
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
     * @param userCreatedDTO UserCreatedDTO
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
     * @param userCreatedDTO UserCreatedDTO
     * @return Shopkeeper
     */
    public Shopkeeper executeShopkeeper(UserCreatedDTO userCreatedDTO) {
        Shopkeeper user = new Shopkeeper();

        createUser(userCreatedDTO, user);

        userRepository.create(user);
        return user;
    }

    /**
     *
     * @param userCreatedDTO UserCreatedDTO
     * @param user Generic user with return
     * @param <T> Generic of Users
     */
    private <T extends User> void createUser(UserCreatedDTO userCreatedDTO, T user) {

        user.setRole(userCreatedDTO.role);
        user.setEmail(userCreatedDTO.email);
        user.setName(userCreatedDTO.name);
        user.setPhone(userCreatedDTO.phone);
        user.setPassword(EncryptPassword.getEncryptPassword(userCreatedDTO.password));

    }

}
