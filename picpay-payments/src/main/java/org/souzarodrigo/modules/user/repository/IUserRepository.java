package org.souzarodrigo.modules.user.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.souzarodrigo.core.models.Admin;
import org.souzarodrigo.core.models.Customer;
import org.souzarodrigo.core.models.Shopkeeper;
import org.souzarodrigo.core.utils.models.users.User;

public interface IUserRepository extends PanacheMongoRepository<User> {

    Customer findByEmailCustomer(String email);

    Shopkeeper findByEmailShopkeeper(String email);

    Admin findByEmailAdmin(String email);
}
