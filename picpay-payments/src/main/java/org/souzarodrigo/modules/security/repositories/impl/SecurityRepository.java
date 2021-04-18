package org.souzarodrigo.modules.security.repositories.impl;

import org.souzarodrigo.global.models.Admin;
import org.souzarodrigo.global.shared.security.dto.UserLoginDTO;
import org.souzarodrigo.global.shared.security.dto.UserTokenDTO;
import org.souzarodrigo.core.utils.security.constants.Roles;
import org.souzarodrigo.core.utils.security.services.TokenService;
import org.souzarodrigo.global.models.Customer;
import org.souzarodrigo.global.models.Shopkeeper;
import org.souzarodrigo.modules.security.repositories.ISecurityRepository;
import org.souzarodrigo.core.utils.security.util.EncryptPassword;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@RequestScoped
public class SecurityRepository implements ISecurityRepository {

    @Inject
    TokenService service;

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

    // TODO Move use case of token to register Use Case

    /**
     *
     * @param userLoginDTO UserLoginDTO
     * @param isExists boolean
     * @param password String
     * @param email String
     * @param role Roles
     * @return UserTokenDTO
     */
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
