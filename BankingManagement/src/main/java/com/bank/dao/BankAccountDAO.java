package com.bank.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bank.bean.BankAccount;
import com.bank.util.DBUtil;

public class BankAccountDAO {

    public void addAccount(BankAccount account) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "INSERT INTO BankAccount (accountHolderName, balance) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, account.getAccountHolderName());
        ps.setDouble(2, account.getBalance());
        ps.executeUpdate();
        con.close();
    }

    public List<BankAccount> getAllAccounts() throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT * FROM BankAccount";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        List<BankAccount> list = new ArrayList<>();

        while (rs.next()) {
            BankAccount acc = new BankAccount(
                    rs.getInt("accountId"),
                    rs.getString("accountHolderName"),
                    rs.getDouble("balance")
            );
            list.add(acc);
        }

        con.close();
        return list;
    }

    public void updateAccount(BankAccount account) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "UPDATE BankAccount SET accountHolderName=?, balance=? WHERE accountId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, account.getAccountHolderName());
        ps.setDouble(2, account.getBalance());
        ps.setInt(3, account.getAccountId());
        ps.executeUpdate();
        con.close();
    }

    public void deleteAccount(int accountId) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "DELETE FROM BankAccount WHERE accountId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, accountId);
        ps.executeUpdate();
        con.close();
    }
}