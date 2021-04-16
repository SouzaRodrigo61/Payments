package org.souzarodrigo.core.utils.models.bank;

public class BankData {

    private Bank bank;
    private String bankAgency;
    private String bankAgencyDigit;
    private String bankAccount;
    private String bankAccountDigit;
    private String operation;

    public BankData(Bank bank, String bankAgency, String bankAgencyDigit, String bankAccount, String bankAccountDigit, String operation) {
        this.bank = bank;
        this.bankAgency = bankAgency;
        this.bankAgencyDigit = bankAgencyDigit;
        this.bankAccount = bankAccount;
        this.bankAccountDigit = bankAccountDigit;
        this.operation = operation;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getBankAgency() {
        return bankAgency;
    }

    public void setBankAgency(String bankAgency) {
        this.bankAgency = bankAgency;
    }

    public String getBankAgencyDigit() {
        return bankAgencyDigit;
    }

    public void setBankAgencyDigit(String bankAgencyDigit) {
        this.bankAgencyDigit = bankAgencyDigit;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankAccountDigit() {
        return bankAccountDigit;
    }

    public void setBankAccountDigit(String bankAccountDigit) {
        this.bankAccountDigit = bankAccountDigit;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public static class Bank {

        private String code;
        private String name;
        private String document;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDocument() {
            return document;
        }

        public void setDocument(String document) {
            this.document = document;
        }

    }
}
