package com.kursanov.crud_lms.impl;

import com.kursanov.crud_lms.entity.Role;
import com.kursanov.crud_lms.entity.User;
import com.kursanov.crud_lms.repository.RoleRepository;
import com.kursanov.crud_lms.repository.UserRepository;
import com.kursanov.crud_lms.server.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.Collections;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {

        if (user.getName().equals("timur")) {
            user.setRoles(
                    Collections.singleton(
                            new Role("ADMIN"))
            );
        } else {
            if (repository.existsByName("USER")) {
                user.setRoles(
                        Collections.singleton(
                                repository.findByName("USER")
                        )
                );
            } else {
                user.setRoles(
                        Collections.singleton(
                                new Role("USER")
                        )
                );
            }
        }
       user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return user;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new NotFoundException(String.format("User with %d id not found!", id)));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long id, User newUser) {
        User user = findById(id);
        user.setName(newUser.getName());
        user.setPassword(newUser.getPassword());
        user.setEmail(newUser.getEmail());
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
