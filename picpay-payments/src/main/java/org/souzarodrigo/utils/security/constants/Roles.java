package org.souzarodrigo.utils.security.constants;

public enum Roles {
    CUSTOMER("CUSTOMER"),
    SHOPKEEPER("SHOPKEEPER"),
    ADMIN("ADMIN");

    private String value;

    Roles(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
