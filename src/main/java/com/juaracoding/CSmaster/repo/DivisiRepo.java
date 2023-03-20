package com.juaracoding.CSmaster.repo;

import com.juaracoding.CSmaster.model.Category;
import com.juaracoding.CSmaster.model.Divisi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DivisiRepo extends JpaRepository<Divisi,Long> {

	Page<Divisi> findByIsDelete(Pageable page , byte byteIsDelete);
	List<Divisi> findByIsDelete(byte byteIsDelete);
	Page<Divisi> findByIsDeleteAndNamaDivisiContainsIgnoreCase(Pageable page , byte byteIsDelete, String values);
	List<Divisi> findByIsDeleteAndNamaDivisiContainsIgnoreCase(byte byteIsDelete, String values);
	Page<Divisi> findByIsDeleteAndIdDivisi(Pageable page , byte byteIsDelete, Long values);
	List<Divisi> findByIsDeleteAndIdDivisi(byte byteIsDelete, Long values);

	Page<Divisi> findByIsDeleteAndIdDivisiContainsIgnoreCase(Pageable pageable, byte b, long parseLong);


}
