package com.kursanov.crud_lms.repository;

import com.kursanov.crud_lms.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    @Override
    List<Teacher> findAll();

    @Override
    <S extends Teacher> S save(S entity);

    @Override
    Optional<Teacher> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
