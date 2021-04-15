package org.souzarodrigo.modules.users.models;

import io.quarkus.mongodb.panache.MongoEntity;
import org.souzarodrigo.utils.models.card.Card;
import org.souzarodrigo.utils.models.users.User;
import org.souzarodrigo.utils.security.constants.Roles;

@MongoEntity(database = "users", collection = "customers")
public class Customer extends User {

    public Card card;

    public Customer() {
        setRole(Roles.CUSTOMER);
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
