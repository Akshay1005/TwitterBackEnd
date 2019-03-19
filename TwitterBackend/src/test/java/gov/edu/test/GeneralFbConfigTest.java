package gov.edu.test;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralFbConfigTest 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext Context=new AnnotationConfigApplicationContext(); 
		 Context.scan("gov.edu");
		 Context.refresh();
		 
		 SessionFactory sessionFactory=(SessionFactory)Context.getBean("sessionFactory");	  
	}
}
