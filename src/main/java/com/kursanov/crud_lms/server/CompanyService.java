package com.kursanov.crud_lms.server;

import com.kursanov.crud_lms.entity.Company;
import com.kursanov.crud_lms.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CompanyService {


    List<Company> findAllCompany();

    Optional<Company> findById(Long id);

    Company saveCompany(Company company);
    Company updateCompany(Long id, Company newCompany);


    void deleteById(Long id);



}
