package com.juaracoding.CSmaster.repo;/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Moh. Ikhsan a.k.a. Fitriyani
Java Developer
Created on 3/19/2023 1:43 PM
@Last Modified 3/19/2023 1:43 PM
Version 1.0
*/



import com.juaracoding.CSmaster.model.Category;
import com.juaracoding.CSmaster.model.Complain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplainRepo extends JpaRepository<Complain, String>{

	Page<Complain> findByIsDelete(Pageable page , byte byteIsDelete);
	List<Complain> findByIsDelete(byte byteIsDelete);
	Page<Complain> findByIsDeleteAndNamaProductContainsIgnoreCase(Pageable page , byte byteIsDelete, String values);
	List<Complain> findByIsDeleteAndNamaProductContainsIgnoreCase(byte byteIsDelete, String values);
	Page<Complain> findByIsDeleteAndNoInvoice(Pageable page , byte byteIsDelete, Long values);
	List<Complain> findByIsDeleteAndNoInvoice(byte byteIsDelete, Long values);

	Page<Complain> findByIsDeleteAndNoInvoiceContainsIgnoreCase(Pageable pageable, byte b, long parseLong);

}
