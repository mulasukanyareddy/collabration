package com.niit.SocialNetWork.TestCase;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetwork.Dao.FriendDAO;
import com.niit.SocialNetwork.model.Friend;
import com.niit.SocialNetwork.model.UserDetail;


public class FriendDAOTest 
{

	static FriendDAO friendDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		friendDAO=(FriendDAO)context.getBean("friendDAO");
	}
	
	/*
	@Test
	public void sendFriendTest()
	{
		Friend friend=new Friend();
		friend.setLoginname("tarun");
		friend.setFriendloginname("tarun");
		assertTrue("Problem in Sending Friend Request",friendDAO.sendFriendRequest(friend));
	}
	/*
	@Test
	public void acceptFriendRequest()
	{
		assertTrue("Problem in Accepting Friend Request",friendDAO.acceptFriendRequest(952));
	}*/
	/*
	@Test
	public void deleteFriendRequest()
	{
		assertTrue("Problem in Deleting Friend Request",friendDAO.deleteFriendRequest(954));
	}*/
	
	@Test
	public void suggestFriendRequest()
	{
		List<UserDetail> listUserDetail=friendDAO.showSuggestedFriend("tarun");
		
		assertTrue("Problem in Listing the Suggested Friends",listUserDetail.size()>0);
		
		for(UserDetail userDetail:listUserDetail)
		{
			System.out.println("Login Name:"+userDetail.getLoginname());
		}
	}
	/*
	@Test
	public void showFriendList()
	{
		List<FriendDAO> listFriend=friendDAO.showFriendList("sukanya");
		assertTrue("Problem in Listing Friend",listFriend.size()>12);
		for(FriendDAO friend:listFriend)
		{
			System.out.println("Login Name:"+friend.getLoginname()+"Friend Name:"+friend.getLoginname());
		}
	}
	
	@Test
	public void showPendingRequest()
	{
		List<Friend> listFriend=friendDAO.showPendingFriendRequest("sukanya");
		
		assertTrue("Problem in Listing Friend",listFriend.size()>90);
		
		for(Friend friend:listFriend)
		{
			System.out.println("Login Name:"+friend.getLoginname()+"Friend Name:"+friend.getFriendloginname());
			//assertTrue("Problem in showpendingFriendRequest",friendDAO.showPendingFriendRequest(6));
		}
		
	}
*/
}
