package org.souzarodrigo.modules.user.models;

import io.quarkus.mongodb.panache.MongoEntity;
import org.souzarodrigo.utils.models.users.User;
import org.souzarodrigo.utils.security.constants.Roles;

@MongoEntity(database = "users", collection = "admins")
public class Admin extends User {

    public Admin() {
        setRole(Roles.ADMIN);
    }
}
