package com.niit.SocialNetwork.Dao;


import java.util.List;

import com.niit.SocialNetwork.model.Forum;




public interface ForumDAO 
{
	public boolean addForum(Forum forum);
	public boolean deleteForum(Forum forum);
	
	public List<Forum> listApprovedForums();
	public List<Forum> listAllForums();
	public boolean approveForum(int forumId);
	public boolean rejectForum(int forumId);
	public Forum getForum(int forumId);
}
