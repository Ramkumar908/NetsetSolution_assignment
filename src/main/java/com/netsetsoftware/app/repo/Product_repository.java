package com.netsetsoftware.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.netsetsoftware.app.Model.Product;

public interface Product_repository  extends JpaRepository<Product,Integer>{
	

	@Query(value="select * from Product where pname= ?1",nativeQuery=true)
	List<Product> findByPname(String product_name);
	
	
	@Query(value="select * from product where pcategory=?1",nativeQuery=true)
	List<Product>findByPcategory(String product_category);
	
	@Query(value="select * from product where pcolor=?1",nativeQuery=true)
	List<Product>findByPcolor(String product_color);


}
