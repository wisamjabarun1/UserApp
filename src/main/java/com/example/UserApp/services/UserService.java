package com.example.UserApp.services;

import com.example.UserApp.Models.User;
import com.example.UserApp.Repository.UserAndAnswerRepository;
import com.example.UserApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
private UserRepository userRepository;
    @Autowired
    private UserAndAnswerRepository userAndAnswerRepository;

    public User save(User user) {
    return userRepository.save(user);

    }

    public User update(User user) {
        return userRepository.update(user);
    }

    public String delete(int id) {
        userRepository.delete(id);
        return userAndAnswerRepository.deleteAnswer(id);
    }

    public Optional<User> getById(int id) {
        return userRepository.getById(id);
    }


}
