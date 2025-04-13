package com.example.UserApp.Repository;


import com.example.UserApp.Models.User;
import com.example.UserApp.Repository.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;


public User save (User user){

try {
    String sql ="INSERT INTO TheUser (Name,Last_Name,Email,Age,Address,Joining_date) VALUES (?, ?, ?, ?, ?,?) ";
    jdbcTemplate.update(sql,user.getName(),user.getLastName(),user.getEmail(),user.getAge(),user.getAddress(),user.getJoiningDate()
    );
    return user;

}catch (Exception e){
    System.out.println(e.getMessage());
    return null;
}
}




public User update(User user ){

try {
    String sql = "UPDATE TheUser SET Name = ?, Last_Name = ?, Email = ?, Age = ?, Address = ?, Joining_date= ?   WHERE id = ?";
    jdbcTemplate.update(sql,user.getName(),user.getLastName(),user.getEmail(),user.getAge(),user.getAddress(),user.getJoiningDate(),user.getId());
    return user;


}catch (Exception e){
    System.out.println(e.getMessage());
    return null;
}

}





    public String delete(int id) {
        try {
            String sql = "DELETE FROM TheUser WHERE Id = ?";
            jdbcTemplate.update(sql, id);
            return "TheUser with id " + id + " deleted successfully";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }




    public Optional<User> getById(int Id) {
        try {
            String sql = "SELECT * FROM TheUser WHERE Id = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new UserMapper(), Id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }

    }


}
