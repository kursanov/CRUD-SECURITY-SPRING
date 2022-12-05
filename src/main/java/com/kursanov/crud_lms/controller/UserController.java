package com.kursanov.crud_lms.controller;

import com.kursanov.crud_lms.entity.Company;
import com.kursanov.crud_lms.entity.User;
import com.kursanov.crud_lms.server.CompanyService;
import com.kursanov.crud_lms.server.StudentService;
import com.kursanov.crud_lms.server.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public User findAll() {
        return (User) userService.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody User user) {
        userService.save(user);
        return "Successfully saved!";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PatchMapping("/update/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.delete(id);
    }

}
