package com.niit.SocialNetwork.Dao;

import java.util.List;

import com.niit.SocialNetwork.model.Blog;
import com.niit.SocialNetwork.model.BlogComment;

public interface BlogDAO 
{
	public boolean addBlog(Blog blog);
	public boolean deleteBlog(int blogId);
	public boolean updateBlog(Blog blog);
	
	public List<Blog> listApprovedBlogs();
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> listAllBlogs();
	public boolean incrementLike(Blog blog);
	
	public boolean addBlogComment(BlogComment blogComment);
	public boolean deleteBlogComment(BlogComment blogComment);
	public BlogComment getBlogComment(int commentId);
	public List<BlogComment> listBlogComments(int blogid);
}
