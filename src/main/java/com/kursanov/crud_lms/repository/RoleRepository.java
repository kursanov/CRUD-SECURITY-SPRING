package com.kursanov.crud_lms.repository;

import com.kursanov.crud_lms.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    boolean existsByName(String name);

    Role findByName(String name);
}
