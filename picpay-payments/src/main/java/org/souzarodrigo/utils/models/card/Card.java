package org.souzarodrigo.utils.models.card;

public class Card {
    private String Holder;
    private String CardNumber;
    private String ExpirationDate;
    private String SecurityCode;
    private String Token;

    public Card(String holder, String cardNumber, String expirationDate, String securityCode, String token) {
        setHolder(holder);
        setCardNumber(cardNumber);
        setExpirationDate(expirationDate);
        setSecurityCode(securityCode);
        setToken(token);
    }

    public String getHolder() {
        return Holder;
    }

    public void setHolder(String holder) {
        Holder = holder;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        ExpirationDate = expirationDate;
    }

    public String getSecurityCode() {
        return SecurityCode;
    }

    public void setSecurityCode(String securityCode) {
        SecurityCode = securityCode;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
