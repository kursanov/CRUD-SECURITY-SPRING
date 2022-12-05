package com.kursanov.crud_lms.repository;

import com.kursanov.crud_lms.entity.Group;
import com.kursanov.crud_lms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {


    @Query("SELECT s FROM Student s WHERE s.firstName LIKE %?1% " +
            "OR s.lastName LIKE %?1%")
    List<Student> findByStudents(String search);

    @Override
    List<Group> findAll();

    @Override
    <S extends Group> S save(S entity);

    @Override
    Optional<Group> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
