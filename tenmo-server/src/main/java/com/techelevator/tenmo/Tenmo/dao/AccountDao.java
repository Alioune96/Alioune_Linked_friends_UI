package com.techelevator.tenmo.Tenmo.dao;

import com.techelevator.tenmo.Tenmo.model.Account;

import java.math.BigDecimal;

public interface AccountDao {
    BigDecimal getbalance(int userId);
    Account getAccountById(int id);

    BigDecimal getAllAccount ();
}
