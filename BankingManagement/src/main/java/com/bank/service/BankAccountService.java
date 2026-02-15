package com.bank.service;

import java.util.List;

import com.bank.bean.BankAccount;
import com.bank.dao.BankAccountDAO;

public class BankAccountService {

    BankAccountDAO dao = new BankAccountDAO();

    public void createAccount(String name, double balance) throws Exception {
        BankAccount account = new BankAccount(name, balance);
        dao.addAccount(account);
    }

    public List<BankAccount> viewAccounts() throws Exception {
        return dao.getAllAccounts();
    }

    public void editAccount(int id, String name, double balance) throws Exception {
        BankAccount account = new BankAccount(id, name, balance);
        dao.updateAccount(account);
    }

    public void removeAccount(int id) throws Exception {
        dao.deleteAccount(id);
    }
}