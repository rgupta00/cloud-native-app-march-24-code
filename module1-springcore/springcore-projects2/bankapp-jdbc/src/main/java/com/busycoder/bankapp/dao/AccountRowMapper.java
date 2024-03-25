package com.busycoder.bankapp.dao;

import com.busycoder.bankapp.dto.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return  new Account(rs.getInt(1),rs.getString(2),rs.getDouble(3));
    }
}
