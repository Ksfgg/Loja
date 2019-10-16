package com.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modelo.model.Produto;

public interface CrudRepository extends org.springframework.data.repository.CrudRepository<Produto, Long> {

}
