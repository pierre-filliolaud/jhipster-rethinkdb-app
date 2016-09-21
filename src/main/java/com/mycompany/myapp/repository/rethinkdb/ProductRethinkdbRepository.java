package com.mycompany.myapp.repository.rethinkdb;

import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.Product;

@Repository
public class ProductRethinkdbRepository extends RethinkdbRepository<Product, Long>{

}
