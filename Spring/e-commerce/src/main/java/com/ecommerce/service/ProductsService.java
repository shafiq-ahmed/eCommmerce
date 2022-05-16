package com.ecommerce.service;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.ecommerce.entity.Products;

import org.springframework.data.jpa.repository.Query;

import antlr.collections.List;

public interface ProductsService {
	
	public Products getProduct(String productId);

	public Products addProducts(Products product);

	public Products getProductById(String id);

	public Stream<Products> getAllProducts();
}
