package org.souzarodrigo.modules.user.models;

import io.quarkus.mongodb.panache.MongoEntity;
import org.souzarodrigo.utils.models.card.Card;
import org.souzarodrigo.utils.models.users.User;
import org.souzarodrigo.utils.security.constants.Roles;

@MongoEntity(database = "users", collection = "customers")
public class Customer extends User {

    public Card card;
    private Integer numberTransactions;

    public Customer() {

        setNumberTransactions(0);
        setRole(Roles.CUSTOMER);
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Integer getNumberTransactions() {
        return numberTransactions;
    }

    public void setNumberTransactions(Integer numberTransactions) {
        this.numberTransactions = numberTransactions;
    }
}
