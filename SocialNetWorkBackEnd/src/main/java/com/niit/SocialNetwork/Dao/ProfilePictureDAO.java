package com.niit.SocialNetwork.Dao;

import com.niit.SocialNetwork.model.ProfilePicture;

public interface ProfilePictureDAO 
{
	public void save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}
