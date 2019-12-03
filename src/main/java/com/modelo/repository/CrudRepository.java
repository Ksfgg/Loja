package com.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modelo.model.Produto;

public interface CrudRepository extends JpaRepository<Produto, Long> {

}
