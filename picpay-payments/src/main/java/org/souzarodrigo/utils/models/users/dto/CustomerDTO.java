package org.souzarodrigo.utils.models.users.dto;

import org.souzarodrigo.utils.models.card.Card;

public class CustomerDTO {
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}