package org.souzarodrigo.modules.users.repositories;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.souzarodrigo.modules.users.models.Admin;
import org.souzarodrigo.utils.models.users.User;
import org.souzarodrigo.utils.models.users.dto.UserLoginDTO;
import org.souzarodrigo.utils.models.users.dto.UserTokenDTO;
import org.souzarodrigo.modules.users.models.Customer;
import org.souzarodrigo.modules.users.models.Shopkeeper;

import javax.transaction.Transactional;
import java.util.List;

public interface IUserRepository extends PanacheMongoRepository<User> {


    public Customer findByEmailCustomer(String email);

    public Shopkeeper findByEmailShopkeeper(String email);

    public Admin findByEmailAdmin(String email);

    @Transactional
    public void create(Admin user);

    @Transactional
    public void create(Customer user);

    @Transactional
    public void create(Shopkeeper user);

    public UserTokenDTO loginCustomer(UserLoginDTO userLoginDTO);

    public UserTokenDTO loginShopkeeper(UserLoginDTO userLoginDTO);

    public UserTokenDTO loginAdmin(UserLoginDTO userLoginDTO);
}
