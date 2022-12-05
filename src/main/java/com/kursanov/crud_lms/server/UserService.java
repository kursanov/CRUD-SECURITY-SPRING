package com.kursanov.crud_lms.server;

import com.kursanov.crud_lms.entity.User;

import java.util.List;

public interface UserService {



    User save(User user);

    User findById(Long id);

    List<User> findAll();

    void delete(Long id);

    User update(Long id, User newUser);


}
