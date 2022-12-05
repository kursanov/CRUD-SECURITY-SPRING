package com.kursanov.crud_lms.repository;

import com.kursanov.crud_lms.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    @Override
    List<Course> findAll();

    @Override
    <S extends Course> S save(S entity);

    @Override
    Optional<Course> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
