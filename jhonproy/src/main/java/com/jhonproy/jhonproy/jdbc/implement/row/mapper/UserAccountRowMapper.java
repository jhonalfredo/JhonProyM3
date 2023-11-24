package com.jhonproy.jhonproy.jdbc.implement.row.mapper;

import com.jhonproy.jhonproy.domain.entities.UserAccount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// src/main/java/com/diplomado/courses/repositories/spring/jdbc/implement/row/mapper/UserAccountRowMapper.java
public class UserAccountRowMapper implements RowMapper<UserAccount> {
    @Override
    public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(rs.getLong("id"));
        userAccount.setUsername(rs.getString("username"));
        userAccount.setPassword(rs.getString("password"));
        userAccount.setEmail(rs.getString("email"));
        userAccount.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

        // Mapeo adicional si es necesario
        return userAccount;
    }
}
