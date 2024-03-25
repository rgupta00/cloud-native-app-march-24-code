package com.busycoder.bankapp.dao;

import com.busycoder.bankapp.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class AccountDaoImplJdbc implements AccountDao{

    private DataSource dataSource;

    @Autowired
    public AccountDaoImplJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts=new ArrayList<>();
        Connection connection=null;
        try {
            connection =dataSource.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("select * from accounts");
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                accounts.add(new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return accounts;
    }

    @Override
    public Optional<Account> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void addAccount(Account account) {
        Connection connection=null;
        try {
            connection =dataSource.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("insert into accounts(name, amount) values (?,?)");
            preparedStatement.setString(1, account.getName());
            preparedStatement.setDouble(2, account.getAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void deleteAccount(int id) {

    }
}
