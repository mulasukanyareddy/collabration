myApp.controller("FriendController",function($scope,$http,$rootScope,$location)
		{
	$scope.friend={friend:0,loginname:'',friendloginname:'',status:''};
	$scope.User={loginname:'',password:'',userName:'',emailId:'',mobileNo:'',address:'',role:''}
	$scope.friendList;
	
	$scope.pendingFriendList;
	
	$scope.suggestFriendList;
	
	function showFriendList()
	{
		console.log ('--I am in showFriend List Method----');
		$http.get('http://localhost:8084/socialNetWorkMiddleWares/showFriendList')
		.then(function(response)
				{
			$scope.friendList=responce.data;
			console.log($scope.friendList);
			
				});
	}
	function showpendingFriendList()
	{
		console.log ('--I am in show pending Friend Request ----');
		$http.get('http://localhost:8084/socialNetWorkMiddleWares/showpendingFriendList')
		.then(function(response)
				{
			$scope.pendingfriendList=responce.data;
			console.log($scope.pendingFriendList);
			
				});
	
	}

	$scope. acceptFriend = function(friendId)
	{
		console.log ('--I am in showFriend List Method----');
		$http.get('http://localhost:8084/socialNetWorkMiddleWares/acceptFriendRequest/'+friendId)
		.then(function(response)
				{
			$scope.friendList=responce.data;
			console.log($scope.friendList);
			
				});
	}
	$scope. sendfriendReq= function(friendId)
	{
	
		console.log ('--I am in sendfriend Request----');
		$scope.friend.loginname=$rootScope.currentUser.loginname;
		$scope.friend.friendloginname=loginname;
		console.log($scope.friend);
		$http.get('http://localhost:8084/socialNetWorkMiddleWares/showFriendList')
		.then(function(response)
				{
			$location.path('/showFriendList');
				
			
			
				});
	}
	
	$scope. unfriend= function(friendId)
	{
		console.log('I am in unfriend method ');
		$http.get('http://localhost8097/SocialNetWorkMiddleWare/deleteFriendRequest/'+friendId)
		.then(function(response)
				{
			console.log('Deleted');
			console.log(responce.data);
			$loacation.path('/showFriendList');
				});
	}
	
	showFriendList();
		});
	
	
	
	
	
	
	
	