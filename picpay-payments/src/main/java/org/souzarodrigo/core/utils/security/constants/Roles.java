package org.souzarodrigo.core.utils.security.constants;

public enum Roles {
    CUSTOMER("CUSTOMER"),
    SHOPKEEPER("SHOPKEEPER"),
    ADMIN("ADMIN");

    private final String value;

    Roles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Roles fromString(String text) {
        for (Roles role : Roles.values()) {
            if (role.value.equalsIgnoreCase(text)) {
                return role;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
