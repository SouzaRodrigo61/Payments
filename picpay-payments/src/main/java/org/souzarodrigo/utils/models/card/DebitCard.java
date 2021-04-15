package org.souzarodrigo.utils.models.card;

public class DebitCard  {

    private Card card;
    private boolean Authenticate;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean isAuthenticate() {
        return Authenticate;
    }

    public void setAuthenticate(boolean authenticate) {
        Authenticate = authenticate;
    }
}
