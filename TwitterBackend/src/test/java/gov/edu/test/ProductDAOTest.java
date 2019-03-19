package gov.edu.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gov.edu.dao.ProductDAO;
import gov.edu.model.Product;

public class ProductDAOTest 
{
	static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("gov.edu");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("MackBook");
		product.setProductDesc("Laptops with latest and advanced features");
		product.setProductFeatursdetails("8 gb Ram with 5 tb HardDisk,IOS Processor");
		product.setWarrantyInformation("5 year Warranty");
		product.setStock(100);
		product.setPrice(50000);
		product.setCategoryId(4);
		product.setSupplierId(4);
		
		assertTrue("Problem in adding the Product",productDAO.addProduct(product));
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(1);
		
		assertTrue("Problem in deleting the Product",productDAO.deleteProduct(product));	
	}
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(1);
		product.setPrice(35000);
		product.setStock(200);
		
		assertTrue("Problem in updating the Product",productDAO.updateProduct(product));
	}
   //	@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Product> listProducts=productDAO.listProducts();
		
		assertTrue("Problem in Retrieving the Product",listProducts.size()>0);
		
		for(Product product:listProducts)
		{
			System.out.print(product.getProductId()+"  ");
			System.out.print(product.getProductName()+"  ");
			System.out.print(product.getProductDesc()+"  ");
			System.out.print(product.getProductFeatursdetails()+"  ");
			System.out.println(product.getPrice()+"  ");
		}
	}
}
