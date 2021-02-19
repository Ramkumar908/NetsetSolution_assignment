package com.netsetsoftware.app.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  id;
	private String pname;
	private String pimagepath;
	private String pcategory;
	private String pcolor;
	private int pprice;
	public Product() {
		
	}
	public Product(int id, String pname, String pimagepath, String pcategory, String pcolor, int pprice) {
		super();
		this.id = id;
		this.pname = pname;
		this.pimagepath = pimagepath;
		this.pcategory = pcategory;
		this.pcolor = pcolor;
		this.pprice = pprice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPimagepath() {
		return pimagepath;
	}
	public void setPimagepath(String pimagepath) {
		this.pimagepath = pimagepath;
	}
	public String getPcategory() {
		return pcategory;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
	public String getPcolor() {
		return pcolor;
	}
	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", pimagepath=" + pimagepath + ", pcategory=" + pcategory
				+ ", pcolor=" + pcolor + ", pprice=" + pprice + "]";
	}
	

}
