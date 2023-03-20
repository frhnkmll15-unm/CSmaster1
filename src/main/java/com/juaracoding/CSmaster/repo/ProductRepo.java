package com.juaracoding.CSmaster.repo;/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Moh. Ikhsan a.k.a. Fitriyani
Java Developer
Created on 3/7/2023 10:38 AM
@Last Modified 3/7/2023 10:38 AM
Version 1.0
*/


import com.juaracoding.CSmaster.model.Category;
import com.juaracoding.CSmaster.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, String>{
	Page<Product> findByIsDelete(Pageable page , byte byteIsDelete);
	List<Product> findByIsDelete(byte byteIsDelete);
	Page<Product> findByIsDeleteAndNamaProductContainsIgnoreCase(Pageable page , byte byteIsDelete, String values);
	List<Product> findByIsDeleteAndNamaProductContainsIgnoreCase(byte byteIsDelete, String values);
	Page<Product> findByIsDeleteAndKodeProduct(Pageable page , byte byteIsDelete, Long values);
	List<Product> findByIsDeleteAndKodeProduct(byte byteIsDelete, Long values);

	Page<Product> findByIsDeleteAndKodeProductContainsIgnoreCase(Pageable pageable, byte b, long parseLong);


}
