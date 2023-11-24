package com.jhonproy.jhonproy.jdbc.implement.row.mapper;

import com.jhonproy.jhonproy.domain.entities.UserDetail;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// src/main/java/com/diplomado/courses/repositories/spring/jdbc/implement/row/mapper/UserDetailRowMapper.java
public class UserDetailRowMapper implements RowMapper<UserDetail> {
    @Override
    public UserDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDetail userDetail = new UserDetail();
        userDetail.setId(rs.getLong("id"));
        userDetail.setFirstName(rs.getString("first_name"));
        userDetail.setLastName(rs.getString("last_name"));
        userDetail.setAge(rs.getInt("age"));
        userDetail.setBirthDay(rs.getDate("birth_day").toLocalDate());
        //userDetail.setUserId(rs.getLong("user_id"));

        // Mapeo adicional si es necesario
        return userDetail;
    }
}
