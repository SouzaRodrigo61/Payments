package org.souzarodrigo.modules.users.core.find.useCase;

import kotlin.jvm.Throws;
import org.souzarodrigo.modules.users.repositories.IUserRepository;
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
     * @param context
     * @param role
     * @param targetType
     * @param <T> Tipo generatico
     * @return
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
