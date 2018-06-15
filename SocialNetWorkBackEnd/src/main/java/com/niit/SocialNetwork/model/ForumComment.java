package com.niit.SocialNetwork.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ForumComment {
	
	@Id
	
	int commentid ;
	
	String commenttesst ;
	String loginname;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	
	int forumid  ;
Date	  commentdate ;
	


		    
		    
		    	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getCommenttesst() {
		return commenttesst;
	}
	public void setCommenttesst(String commenttesst) {
		this.commenttesst = commenttesst;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public Date getCommentdate() {
		return commentdate;
	}
	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}
				


}
