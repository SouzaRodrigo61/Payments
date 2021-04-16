package org.souzarodrigo.core.models;

import io.quarkus.mongodb.panache.MongoEntity;
import org.souzarodrigo.core.utils.models.users.User;
import org.souzarodrigo.core.utils.security.constants.Roles;

@MongoEntity(database = "users", collection = "admins")
public class Admin extends User {

    public Admin() {
        setRole(Roles.ADMIN);
    }
}
