package com.example.emailsendingtest.service;

import com.example.emailsendingtest.entity.User;
import com.example.emailsendingtest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> list() {
        return userRepository.findAll();
    }


    public User one(Integer id) {
        return userRepository.findById(id).get();
    }

    public User create(User user) {
        return userRepository.save(user);
    }


    public User update(Integer id, User user) {
        Optional<User> byId = userRepository.findById(id);
        byId.ifPresent(us -> {
            us.setName(user.getName());
            us.setPhone(user.getPhone());
            userRepository.save(us);
        });
        return byId.get();
    }

    public Boolean delete(Integer id) {
        userRepository.deleteById(id);
        return true;
    }
}
