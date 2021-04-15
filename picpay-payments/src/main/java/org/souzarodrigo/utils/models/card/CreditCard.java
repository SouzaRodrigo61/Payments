package org.souzarodrigo.utils.models.card;

public class CreditCard {

    private Card card;
    private Integer InstallmentQuantity;
    private boolean isCancelled;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Integer getInstallmentQuantity() {
        return InstallmentQuantity;
    }

    public void setInstallmentQuantity(Integer installmentQuantity) {
        InstallmentQuantity = installmentQuantity;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}
