package org.souzarodrigo.core.utils.models.users.dto;

import org.souzarodrigo.core.utils.models.bank.BankData;

public class ShopkeeperDTO {
    private BankData bankData;
    private Double bankBalance;

    public BankData getBankData() {
        return bankData;
    }

    public void setBankData(BankData bankData) {
        this.bankData = bankData;
    }

    public Double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(Double bankBalance) {
        this.bankBalance = bankBalance;
    }
}