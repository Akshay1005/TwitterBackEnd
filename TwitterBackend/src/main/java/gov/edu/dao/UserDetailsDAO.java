package gov.edu.dao;

import gov.edu.model.UserDetails;

public interface UserDetailsDAO
{
	public boolean registerUser(UserDetails user);
	public boolean updateUser(UserDetails user);
	public UserDetails getUser(String username);
}
