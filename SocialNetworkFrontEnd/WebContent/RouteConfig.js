var myApp=angular.module("myApp",['ngRoute','ngCookies']);

myApp.config(function($routeProvider)
		{
			alert("I am route module ")
			$routeProvider.when("/",{templateUrl:"/index.html"})
		
			.when("/login",{templateUrl:"c_user/login.html"})
			.when("/register",{templateUrl:"c_user/register.html"})
			.when("/aboutus",{templateUrl:"pages/AboutUs.html"})
			.when("/contactus",{templateUrl:"pages/ContactUs.html"})
			.when("/Blog",{templateUrl:"c_blog/blog.html"})
			.when("/ShowAllBlog",{templateUrl:"c_blog/ShowAllBlog.html"})
			.when("/AdminBlog",{templateUrl:"c_blog/AdminBlog.html"})
			.when("/myBlogs",{templateUrl:"c_blog/MyBlog.html"})
			.when("/AddBlog",{templateUrl:"c_blog/AddBlog.html"})
			.when("/AddForum",{templateUrl:"c_forum/AddForum.html"})
			.when("/ShowForum",{templateUrl:"c_forum/ShowForum.html"})
			.when("/AdminForum",{templateUrl:"c_forum/AdminForum.html"})
			.when("/BlogComment",{templateUrl:"c_Blog/BlogComment.html"})
			.when("/profilepicture",{templateUrl:"c_user/profilepicture.html"})
			.when("/ShowFriendList",{templateUrl:"c_friend/ShowFriendList.html"})
			.when("/ShowpendingFriendList",{templateUrl:"c_friend/ShowpendingFriendList.html"})
			.when("/ShowSuggestedFriendList",{templateUrl:"c_friend/ShowSuggestedFriendList.html"})
			.when("/chat",{templateUrl:"c_chat/Chat.html"});
			
			
			
			
		});