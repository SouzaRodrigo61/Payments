package org.souzarodrigo.modules.users.models;

import io.quarkus.mongodb.panache.MongoEntity;
import org.souzarodrigo.utils.models.bank.BankData;
import org.souzarodrigo.utils.models.users.User;
import org.souzarodrigo.utils.security.constants.Roles;

@MongoEntity(database = "users", collection = "shopkeepers")
public class Shopkeeper extends User {

    private BankData bankData;

    public Shopkeeper() {
        setRole(Roles.SHOPKEEPER);
    }

    public BankData getBankData() {
        return bankData;
    }

    public void setBankData(BankData bankData) {
        this.bankData = bankData;
    }
}
