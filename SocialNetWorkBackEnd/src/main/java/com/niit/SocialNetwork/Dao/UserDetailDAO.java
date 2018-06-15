package com.niit.SocialNetwork.Dao;

import com.niit.SocialNetwork.model.UserDetail;

public interface UserDetailDAO 
{
	public boolean registerUser(UserDetail userDetail);
	public boolean checkCredential(UserDetail userDetail);
	public UserDetail getUser(String loginname);

}
