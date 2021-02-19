package com.netsetsoftware.app.service;

import java.util.List;

import com.netsetsoftware.app.Model.Product;

public interface Product_service {

	
	public List<Product> add_product(Product product);
	public List<Product> search_by_name(String product_name);
	public List<Product> serach_by_category(String product_category);
	public List<Product> serach_by_color(String product_color);
	
}
