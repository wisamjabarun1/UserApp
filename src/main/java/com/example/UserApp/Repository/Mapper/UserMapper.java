package com.example.UserApp.Repository.Mapper;

import com.example.UserApp.Models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(); // use lowercase variable name
        user.setId(rs.getInt("Id"));
        user.setName(rs.getString("Name"));
        user.setLastName(rs.getString("Last_Name"));
        user.setEmail(rs.getString("Email"));
        user.setAge(rs.getInt("Age"));
        user.setAddress(rs.getString("Address"));
        user.setJoiningDate(rs.getDate("Joining_date"));




        return user;
    }


}
