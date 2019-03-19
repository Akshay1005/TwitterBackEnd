package gov.edu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product 
{
	@Id
	@GeneratedValue
	int productId;
	
	String productName;
	String productDesc;
	String productFeatursdetails;
	String WarrantyInformation;
	
	int categoryId;
	int supplierId;
	
	int stock;
	int price;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProductFeatursdetails() {
		return productFeatursdetails;
	}
	public void setProductFeatursdetails(String productFeatursdetails) {
		this.productFeatursdetails = productFeatursdetails;
	}
	public String getWarrantyInformation() {
		return WarrantyInformation;
	}
	public void setWarrantyInformation(String warrantyInformation) {
		WarrantyInformation = warrantyInformation;
	}
}
