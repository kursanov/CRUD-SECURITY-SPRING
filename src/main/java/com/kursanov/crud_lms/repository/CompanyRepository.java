package com.kursanov.crud_lms.repository;

import com.kursanov.crud_lms.entity.Company;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    @Override
    <S extends Company> List<S> findAll(Example<S> example);

    @Override
    <S extends Company> S save(S entity);

    @Override
    Optional<Company> findById(Long aLong);


    @Override
    <S extends Company> long count(Example<S> example);

    @Override
    void deleteById(Long aLong);
}
