package org.souzarodrigo.modules.users.repositories.impl;

import org.souzarodrigo.modules.users.models.Admin;
import org.souzarodrigo.utils.models.users.dto.UserLoginDTO;
import org.souzarodrigo.utils.models.users.dto.UserTokenDTO;
import org.souzarodrigo.utils.security.constants.Roles;
import org.souzarodrigo.utils.security.services.TokenService;
import org.souzarodrigo.utils.models.users.User;
import org.souzarodrigo.modules.users.models.Customer;
import org.souzarodrigo.modules.users.models.Shopkeeper;
import org.souzarodrigo.modules.users.repositories.IUserRepository;
import org.souzarodrigo.utils.security.util.EncryptPassword;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
public class UserRepository implements IUserRepository {

    @Inject
    TokenService service;

    @Override
    public Customer findByEmailCustomer(String email) {
        return Customer.find("email", email).firstResult();
    }

    @Override
    public Shopkeeper findByEmailShopkeeper(String email) {
        return Shopkeeper.find("email", email).firstResult();
    }

    @Override
    public Admin findByEmailAdmin(String email) {
        return Admin.find("email", email).firstResult();
    }

    @Override
    public void create(Admin user) {
        user.persist();
    }

    @Override
    public void create(Customer user) {
        user.persist();
    }

    @Override
    public void create(Shopkeeper user) {
        user.persist();
    }

    @Override
    public UserTokenDTO loginCustomer(UserLoginDTO userLoginDTO) {
        Customer existingUser = Customer.find("email", userLoginDTO.getEmail()).firstResult();

        return getUserTokenDTO(userLoginDTO, existingUser == null, existingUser.getPassword(), existingUser.getEmail(), existingUser.role);
    }

    @Override
    public UserTokenDTO loginShopkeeper(UserLoginDTO userLoginDTO) {
        Shopkeeper existingUser = Shopkeeper.find("email", userLoginDTO.getEmail()).firstResult();

        return getUserTokenDTO(userLoginDTO, existingUser == null, existingUser.getPassword(), existingUser.getEmail(), existingUser.role);
    }

    @Override
    public UserTokenDTO loginAdmin(UserLoginDTO userLoginDTO) {
        Admin existingUser = Admin.find("email", userLoginDTO.getEmail()).firstResult();

        return getUserTokenDTO(userLoginDTO, existingUser == null, existingUser.getPassword(), existingUser.getEmail(), existingUser.role);
    }

    private UserTokenDTO getUserTokenDTO(UserLoginDTO userLoginDTO, boolean isExists, String password, String email, Roles role) {

        if(isExists || !password.equals(EncryptPassword.getEncryptPassword(userLoginDTO.getPassword()))) {
            throw new WebApplicationException(Response.status(404).entity("No user found or password is incorrect").build());
        }

        UserTokenDTO userTokenDTO = new UserTokenDTO();
        String token;

        switch (role) {
            case ADMIN:
                token = service.generateAdminToken(email, userLoginDTO.getEmail());
                userTokenDTO.setToken(token);
                break;
            case SHOPKEEPER:
                token = service.generateShopkeeperToken(email, userLoginDTO.getEmail());
                userTokenDTO.setToken(token);
                break;
            case CUSTOMER:
                token = service.generateCustomerToken(email, userLoginDTO.getEmail());
                userTokenDTO.setToken(token);
                break;
        }
        return userTokenDTO;
    }

}
