package org.souzarodrigo.modules.security.repositories;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.souzarodrigo.global.models.Admin;
import org.souzarodrigo.global.shared.users.User;
import org.souzarodrigo.global.shared.security.dto.UserLoginDTO;
import org.souzarodrigo.global.shared.security.dto.UserTokenDTO;
import org.souzarodrigo.global.models.Customer;
import org.souzarodrigo.global.models.Shopkeeper;

import javax.transaction.Transactional;

public interface ISecurityRepository extends PanacheMongoRepository<User> {


    @Transactional
    void create(Admin user);

    @Transactional
    void create(Customer user);

    @Transactional
    void create(Shopkeeper user);

    UserTokenDTO loginCustomer(UserLoginDTO userLoginDTO);

    UserTokenDTO loginShopkeeper(UserLoginDTO userLoginDTO);

    UserTokenDTO loginAdmin(UserLoginDTO userLoginDTO);
}
