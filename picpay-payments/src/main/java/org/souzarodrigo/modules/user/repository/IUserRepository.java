package org.souzarodrigo.modules.user.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.souzarodrigo.modules.user.models.Admin;
import org.souzarodrigo.modules.user.models.Customer;
import org.souzarodrigo.modules.user.models.Shopkeeper;
import org.souzarodrigo.utils.models.users.User;

public interface IUserRepository extends PanacheMongoRepository<User> {

    Customer findByEmailCustomer(String email);

    Shopkeeper findByEmailShopkeeper(String email);

    Admin findByEmailAdmin(String email);
}
