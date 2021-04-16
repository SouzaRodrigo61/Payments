package org.souzarodrigo.modules.user.core.find.useCase;

import org.souzarodrigo.modules.security.repositories.ISecurityRepository;
import org.souzarodrigo.modules.user.repository.IUserRepository;
import org.souzarodrigo.utils.security.constants.Roles;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
public class FindUserUseCase {

    @Inject
    IUserRepository userRepository;

    /**
     *
     * @param context Security context
     * @param role Role allowed
     * @param targetType Class target of users
     * @param <T> Generic type of Users
     * @return Object extends Users
     */
    public <T> T executeFindUser(SecurityContext context, Roles role, Class<T> targetType) {
        String email = context.getUserPrincipal().getName();

        switch (role) {
            case ADMIN:
                return targetType.cast(userRepository.findByEmailAdmin(email));
            case CUSTOMER:
                return targetType.cast(userRepository.findByEmailCustomer(email));
            case SHOPKEEPER:
                return targetType.cast(userRepository.findByEmailShopkeeper(email));
            default:
                throw new WebApplicationException("Retorna um erro");
        }

    }
}
