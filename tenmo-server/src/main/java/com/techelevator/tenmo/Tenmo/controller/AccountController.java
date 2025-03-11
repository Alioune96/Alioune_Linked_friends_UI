package com.techelevator.tenmo.Tenmo.controller;

import com.techelevator.tenmo.Tenmo.dao.AccountDao;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {
    private AccountDao accountDao;

    public AccountController(AccountDao accountDao){
        this.accountDao = accountDao;
    }


    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public BigDecimal forTest(){
      return   accountDao.getAllAccount();
    }

    @RequestMapping(path = "test/{userId}", method = RequestMethod.GET)
    public BigDecimal currentUserBalance(@PathVariable int userId ){
        return accountDao.getbalance(userId);

    }



}
