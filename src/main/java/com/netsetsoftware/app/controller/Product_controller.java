package com.netsetsoftware.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.netsetsoftware.app.Model.Product;
import com.netsetsoftware.app.service.Product_service;

@RestController
public class Product_controller {
	
	private  static Logger logger=LoggerFactory.getLogger(Product_controller.class);

	@Autowired 
	Product_service  add_product_serice;
	/*
	 * Add Product
	 * @Param  Product product
	 * return product
	 */
	@RequestMapping(value="/add_product",method= {RequestMethod.POST})
	public @ResponseBody ResponseEntity<Object> add_product(@RequestBody Product  product)
	{
		
		if(product==null)
		{
			return new ResponseEntity<Object>("Parameter is missing ",HttpStatus.BAD_REQUEST);
		}
		List<Product>productList=add_product_serice.add_product(product);
		return new ResponseEntity<Object>(productList,HttpStatus.OK);

	}
	
	/*
	 * Search Product  by pname
	 * @Param  String product_name
	 * return productList by product_name
	 * testing url:http://localhost:8080/getProduct_by_name/product_name
	 */
	@RequestMapping(value="/getProduct_by_name/{product_name}",method= {RequestMethod.GET})
	public @ResponseBody ResponseEntity<Object> getProductByName(@PathVariable("product_name") String product_name)
	{
		logger.info("the user at this point",product_name);

		List<Product> ProductNameList=add_product_serice.search_by_name(product_name);
		if(ProductNameList==null|| ProductNameList.size()<=0)
		{
			new ResponseEntity<Object>("Product not found with given name :"+product_name,HttpStatus.BAD_REQUEST);
		}

		  return new ResponseEntity<Object>(ProductNameList,HttpStatus.OK);
		
	}

	/*
	 * Search Product  by pcategory
	 * @Param  String product_category
	 * return productList by product_category
	 * http://localhost:8080/getProduct_by_category/product_category
	 */
	
	@RequestMapping(value="/getProduct_by_category/{product_category}",method= {RequestMethod.GET})
	public @ResponseBody ResponseEntity<Object> getProductByCategory(@PathVariable("product_category") String product_category)
	{
		logger.info("The getting parameter for product serch by category  ", product_category);		
		List<Product>ProductCategoryList=add_product_serice.serach_by_category(product_category);
		if(ProductCategoryList==null||ProductCategoryList.size()<=0)
		{
			new ResponseEntity<Object>("product not find wit given category :"+product_category,HttpStatus.BAD_REQUEST);
		}
	  return new ResponseEntity<Object>(ProductCategoryList,HttpStatus.OK);
		
	}
	
	/*
	 * Search Product  by pcolor
	 * @Param  String product_color
	 * return productList by product_color
	 * http://localhost:8080/getProduct_by_color/product_color
	 */
	@RequestMapping(value="/getProduct_by_color/{product_color}",method= {RequestMethod.GET})
	public @ResponseBody ResponseEntity<Object> getProductByColor(@PathVariable("product_color") String product_color)
	{
		logger.info("the user at this point",product_color);
		
		     List<Product> myproduct=null;
			 myproduct=add_product_serice.serach_by_color(product_color);
		
		    if(myproduct==null || myproduct.size()<=0)
		    {
			return new ResponseEntity<Object>("The product not find with given color name  :"+product_color,HttpStatus.BAD_REQUEST);
		    }
		
           return new ResponseEntity<Object>(myproduct,HttpStatus.OK);
	}

}
