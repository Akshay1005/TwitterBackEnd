package gov.edu.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gov.edu.dao.CategoryDAO;
import gov.edu.model.Category;

public class CategoryDAOTest 
{	
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("gov.edu");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("Lenovo Laptops");
		category.setCategoryDesc("All Brands of Lenovo Laptops");
		
		assertTrue("Problem in Adding Category",categoryDAO.addCategory(category));	
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(6);
		assertTrue("Problem in Deleting Category",categoryDAO.deleteCategory(category));
	}
	@Ignore
	@Test 
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		
		//category.setCategoryName("MackBook");
		category.setCategoryDesc("All Brands of Lenovo Laptops");
		assertTrue("Problem in Updating Category",categoryDAO.updateCategory(category));
	}
	//@Ignore
	@Test
	public void retrieveCategoryTest()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		assertTrue("Probelm in Retrieving the Category",listCategories.size()>0);
		
		for(Category cat:listCategories)
		{
			
			System.out.print(cat.getCategoryId()+"   ");
			System.out.print(cat.getCategoryName()+"   ");
			System.out.println(cat.getCategoryDesc()+"   ");
			
		}	
	}
}
