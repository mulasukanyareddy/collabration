package com.niit.SocialNetWorkRestController;




import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialNetwork.Dao.FriendDAO;
import com.niit.SocialNetwork.model.Friend;
import com.niit.SocialNetwork.model.UserDetail;


@RestController
public class FriendController 
{
	@Autowired
	FriendDAO friendDAO;

	@PostMapping(value="/sendFriendRequest")
	public ResponseEntity<String> sendFriendRequest(@RequestBody Friend friend)
	{
		if(friendDAO.sendFriendRequest(friend))
		{
			return new ResponseEntity<String>("success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("success",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/showFriendList")
	public ResponseEntity<List<Friend>> showFriendList(HttpSession session)
	{
		String loginname=((UserDetail)session.getAttribute("userDetail")).getLoginname();
		List<FriendDAO> listFriends=friendDAO.showFriendList(loginname);
		
		if(listFriends.size()>0)
		{
			return new ResponseEntity<List<Friend>>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/showPendingFriendRequest")
	public ResponseEntity<List<Friend>> showPendingFriendRequest(HttpSession session)
	{
		String loginname=((UserDetail)session.getAttribute("userDetail")).getLoginname();
		List<Friend> pendingFriendRequest=friendDAO.showPendingFriendRequest(loginname);
		
		if(pendingFriendRequest.size()>0)
		{
			return new ResponseEntity<List<Friend>>(pendingFriendRequest,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(pendingFriendRequest,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/showSuggestedFriend")
	public ResponseEntity<List<UserDetail>> showSuggestedFriend(HttpSession session)
	{
		String loginname=((UserDetail)session.getAttribute("userDetail")).getLoginname();
		List<UserDetail> showSuggestedFriend=friendDAO.showSuggestedFriend(loginname);
		
		if(showSuggestedFriend.size()>0)
		{
			return new ResponseEntity<List<UserDetail>>(showSuggestedFriend,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<UserDetail>>(showSuggestedFriend,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/acceptFriendRequest/{friendID}")
	public ResponseEntity<String> acceptFriendRequest(@PathVariable("friendID") int friendId)
	{
		if(friendDAO.acceptFriendRequest(friendId))
		{
			return new ResponseEntity<String>("success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("failure",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/deleteFriendRequest/{friendID}")
	public ResponseEntity<String> deleteFriendRequest(@PathVariable("friendID") int friendId)
	{
		if(friendDAO.deleteFriendRequest(friendId))
		{
			return new ResponseEntity<String>("success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("failure",HttpStatus.NOT_FOUND);
		}
	}
	
}
