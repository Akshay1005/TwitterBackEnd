package gov.edu.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import gov.edu.dao.UserDetailsDAO;
import gov.edu.model.UserDetails;

public class UserDetailsDAOTest 
{
static UserDetailsDAO userDetailsDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("gov.edu");
		context.refresh();
		
		userDetailsDAO=(UserDetailsDAO)context.getBean("UserDetailsDAO");
	}
	//@Ignore
	@Test
	public void registerUserDetailsTest()
	{
		UserDetails user=new UserDetails();
		user.setUsername("Shekar");
		user.setPassword("admin");
		user.setCustomerName("Shekar Kumar");
		user.setGender("MALE");
		user.setMobileNo("7386898663");
		user.setAddress("Secunderabad");
		user.setPinCode(500061);
		user.setRole("ROLE_USER");
		user.setEnable(true);
		
		assertTrue("Problem in adding the user:",userDetailsDAO.registerUser(user));
	}
	@Ignore
	@Test
	public void updateUserDetailsTest()
	{
		UserDetails user=userDetailsDAO.getUser("Rohith");
		user.setPassword("88888");
		
		assertTrue("Problem in Updating the UserDetails:",userDetailsDAO.updateUser(user));	
	}
}
