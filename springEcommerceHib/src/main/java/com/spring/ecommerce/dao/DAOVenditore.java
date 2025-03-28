package com.spring.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ecommerce.entity.Venditore;

public interface DAOVenditore extends JpaRepository<Venditore, Integer> {

}
