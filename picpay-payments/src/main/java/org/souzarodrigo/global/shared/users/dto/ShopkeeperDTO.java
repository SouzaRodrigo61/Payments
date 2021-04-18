package org.souzarodrigo.global.shared.users.dto;

import org.souzarodrigo.global.shared.bank.BankData;

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