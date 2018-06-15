package com.niit.SocialNetwork.Dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialNetwork.model.ProfilePicture;



@Repository("profilePictureDAO")
public class ProfilePictureDAOImpl implements ProfilePictureDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	

	public void save(ProfilePicture profilePicture) 
	{
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(profilePicture);
		session.flush();
		session.close();
		
	}
	public ProfilePicture getProfilePicture(String username) 
	{
		Session session=sessionFactory.openSession();
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class, username);
		session.close();
		return profilePicture;
	}
	
	
}
