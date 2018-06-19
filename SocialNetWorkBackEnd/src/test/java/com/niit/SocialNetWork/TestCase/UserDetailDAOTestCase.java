package com.niit.SocialNetWork.TestCase;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetwork.Dao.UserDetailDAO;
import com.niit.SocialNetwork.model.UserDetail;



public class UserDetailDAOTestCase 
{
	static UserDetailDAO userDetailDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		userDetailDAO=(UserDetailDAO)context.getBean("userDetailDAO");
	}
	
	
	@Test
	public void registerUserTest()
	{
		UserDetail userDetail=new UserDetail();
		
		userDetail.setLoginname("reddy");
		userDetail.setPassword("reddy123");
		userDetail.setUserName("reddy");
		userDetail.setEmailId("reddy@gmail.com");
		userDetail.setAddress("india");
		userDetail.setMobileNo("9492286794");
		userDetail.setRole("ROLE_Admin");
		
		assertTrue("Problem in Registering User",userDetailDAO.registerUser(userDetail));
	}
	/*
	@Test
	public void checkUserTest()
	{
		UserDetail userDetail=new UserDetail();
		userDetail.setLoginname("sridhar");
		userDetail.setPassword("pass123");
		
		assertTrue("Problem in Login Process:",userDetailDAO.checkCredential(userDetail));
		
	}*/
	/*
	@Test 
	public void getUserTest()
	{
	
		
			assertNotNull("Problem in Accessing a User",userDetailDAO.getUser("sukanya"));
		
			
	
	}*/	
		
	
}
