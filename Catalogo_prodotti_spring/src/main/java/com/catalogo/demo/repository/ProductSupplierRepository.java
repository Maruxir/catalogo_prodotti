package com.catalogo.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.catalogo.demo.model.Product_supplier;
import com.catalogo.demo.model.Roles;
import com.catalogo.demo.service.ProductService;

public interface ProductSupplierRepository extends CrudRepository<Product_supplier, Integer>{

}
