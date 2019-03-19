package gov.edu.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import gov.edu.model.Category;
import gov.edu.model.Product;
import gov.edu.model.UserDetails;

@Configuration
@EnableTransactionManagement
@ComponentScan("gov.edu")

public class FBConfig 
{
	@Bean
	public DataSource getH2DataSource()

	{
		DriverManagerDataSource ds=new DriverManagerDataSource();   //ds=datasource
		ds.setDriverClassName("org.h2.Driver");	
		ds.setUrl("jdbc:h2:tcp://localhost/~/test123");
		ds.setUsername("sa");
		ds.setPassword("sa");
		
		System.out.println("%%%%%%%%% Data Source Object Created Successfully %%%%%%%%%%");
		return ds;
	} 	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder fc=new LocalSessionFactoryBuilder(getH2DataSource());
		fc.addProperties(hibernateProp);
		
		fc.addAnnotatedClass(Category.class);   //Mapping resources
		fc.addAnnotatedClass(Product.class);   //Mapping resources
		fc.addAnnotatedClass(UserDetails.class);   //Mapping resources
		
		SessionFactory sessionFactory=fc.buildSessionFactory();
		
		System.out.println("%%%%%%%% SessionFactory object created Successfully %%%%%%%%%");
		return sessionFactory;	
	}
	@Bean("txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("%%%%%%%%% Hibernate Transaction Manager %%%%%%%%%%%");
		return new HibernateTransactionManager(sessionFactory);
	}
} 




