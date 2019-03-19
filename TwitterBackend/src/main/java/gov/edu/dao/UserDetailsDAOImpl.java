package gov.edu.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gov.edu.model.UserDetails;

import gov.edu.model.UserDetails;

@Repository("UserDetailsDAO")
@Transactional
public class UserDetailsDAOImpl implements UserDetailsDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(UserDetails user) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@Override
	public boolean updateUser(UserDetails user)
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@Override
	public UserDetails getUser(String username) 
	{
		Session session=sessionFactory.openSession();
		UserDetails userDetail=session.get(UserDetails.class, username);
		session.close();
		return userDetail;	
	}

}
