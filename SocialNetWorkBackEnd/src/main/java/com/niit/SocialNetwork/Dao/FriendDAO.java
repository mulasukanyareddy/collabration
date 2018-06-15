package com.niit.SocialNetwork.Dao;

import java.util.List;

import com.niit.SocialNetwork.model.Friend;
import com.niit.SocialNetwork.model.UserDetail;


public interface FriendDAO 
{
	public List<FriendDAO> showFriendList(String loginname);
	public List<Friend> showPendingFriendRequest(String loginname);
	public List<UserDetail> showSuggestedFriend(String loginname);
	
	public boolean sendFriendRequest(Friend friend);
	public boolean acceptFriendRequest(int friendId);
	public boolean deleteFriendRequest(int friendId);
	public void setStatus(String string);
	public String getLoginname();
	public boolean showpending(int i);
	public boolean showPendingFriendRequest(int i);
}
