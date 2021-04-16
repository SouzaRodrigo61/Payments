package org.souzarodrigo.utils.models.users.dto;

import org.souzarodrigo.utils.models.bank.BankData;
import org.souzarodrigo.utils.models.card.Card;

public class UserUpdateDTO {

    public Integer numberTransactions;

    public CustomerDTO customer;
    public ShopkeeperDTO shopkeeper;

    public UserUpdateDTO() {
    }

}
