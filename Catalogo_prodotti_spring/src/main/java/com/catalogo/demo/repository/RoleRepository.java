package com.catalogo.demo.repository;

import javax.management.relation.Role;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.demo.model.Roles;


@Repository
public interface RoleRepository extends CrudRepository<Roles, Integer>{
	//@Query(value = "select * from role a where a.name like ?1", nativeQuery = true)
	 Roles findByName(String name);

	//Roles save(Roles role);
}
