package com.jmd.controllers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddProductRepository extends JpaRepository<Products, Long> {

	@Query("SELECT abc FROM Products AS abc WHERE abc.id=:id ")
	public List<Products> findById(@Param("id") long id);
	@Query("SELECT productname FROM Products")
	public List<Products> find(@Param("productname") String productname);
}
