package com.kursanov.crud_lms.repository;

import com.kursanov.crud_lms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Override
    List<User> findAll();

    @Override
    <S extends User> S save(S entity);

    @Override
    Optional<User> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

    User findByName(String name);
}
