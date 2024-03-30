package com.busycoder.bankapp.dao;

import com.busycoder.bankapp.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class AccountDaoImplJdbcTemplate implements AccountDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountDaoImplJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Account> getAll() {
       return jdbcTemplate.query("select * from accounts",new AccountRowMapper());
    }

    @Override
    public Optional<Account> getById(int id) {
        Account account=jdbcTemplate.queryForObject("select * from accounts where id=?",new AccountRowMapper(), id);
        return Optional.ofNullable(account);
    }

    @Override
    public void updateAccount(Account account) {
        String udateQuery="update accounts set amount=? where id=?";
        jdbcTemplate.update(udateQuery, new Object[]{ account.getAmount(), account.getId()});
    }

    @Override
    public void addAccount(Account account) {
          String addQuery="insert into accounts(name, amount) values (?,?)";
         jdbcTemplate.update(addQuery, new Object[]{account.getName(), account.getAmount()});
    }

    @Override
    public void deleteAccount(int id) {
        String deleteQuery="delete from accounts where id=?";
        jdbcTemplate.update(deleteQuery, id);
    }
}
