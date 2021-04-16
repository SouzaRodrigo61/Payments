package org.souzarodrigo.modules.security.repositories;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.souzarodrigo.modules.user.models.Admin;
import org.souzarodrigo.utils.models.users.User;
import org.souzarodrigo.utils.models.security.dto.UserLoginDTO;
import org.souzarodrigo.utils.models.security.dto.UserTokenDTO;
import org.souzarodrigo.modules.user.models.Customer;
import org.souzarodrigo.modules.user.models.Shopkeeper;

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