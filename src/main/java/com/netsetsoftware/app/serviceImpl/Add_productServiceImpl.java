package com.netsetsoftware.app.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsetsoftware.app.Model.Product;
import com.netsetsoftware.app.repo.Product_repository;
import com.netsetsoftware.app.service.Product_service;

@Service
public class Add_productServiceImpl implements Product_service {

	@Autowired
	Product_repository product_repo;
	private static Logger logger = LoggerFactory.getLogger(Add_productServiceImpl.class);

	// private static final String SAVE_DIR="/images/";
	@Override
	public List<Product> add_product(Product product) {
		try {
			product_repo.save(product);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product_repo.findAll();
	}

	@Override
	public List<Product> search_by_name(String product_name) {

		return product_repo.findByPname(product_name);
	}

	@Override
	public List<Product> serach_by_category(String product_category) {
		// TODO Auto-generated method stub
		return product_repo.findByPcategory(product_category);
	}

	@Override
	public List<Product> serach_by_color(String product_color) {

		logger.info("The productList is fetching here " + product_color);
		return product_repo.findByPcolor(product_color);

	}

}
