package com.example.emailsendingtest.controller;

import com.example.emailsendingtest.entity.User;
import com.example.emailsendingtest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/{id}")
    public User one(@PathVariable Integer id) {
        return userService.one(id);
    }
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody User user) {
        return userService.update(id, user);
    }
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return userService.delete(id);
    }
}
