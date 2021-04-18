package org.souzarodrigo.modules.user.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.souzarodrigo.global.models.Admin;
import org.souzarodrigo.global.models.Customer;
import org.souzarodrigo.global.models.Shopkeeper;
import org.souzarodrigo.global.shared.users.User;

public interface IUserRepository extends PanacheMongoRepository<User> {

    Customer findByEmailCustomer(String email);

    Shopkeeper findByEmailShopkeeper(String email);

    Admin findByEmailAdmin(String email);
}
