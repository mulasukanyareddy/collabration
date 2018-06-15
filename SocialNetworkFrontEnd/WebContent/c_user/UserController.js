	
	myApp.controller("UserController",function($scope,$http,$rootScope,$location)
			{
		
			$scope.User={loginname:'',password:'',userName:'',emailId:'',mobileNo:'',address:'',role:''};
			
			$scope.register=function()
			{	
				$scope.User.role='ROLE_USER';
				
				//http://localhost:8097/SocialNetWorkMiddleWares/
				
				$http.post('http://localhost:8097/SocialNetWorkMiddleWares/registerUser',$scope.User)
				.then(function(response)
						 {
						 console.log('The user registered successfully');
						 alert('User Registered Successfully');
						 console.log(response.statusText);
						 });
				
			}
			
			$scope.checklogin=function()
			{
				alert("Checking Login Process");
				
				$http.post('http://localhost:8097/SocialNetWorkMiddleWares/checkLogin',$scope.User)
				.then(function(response)
						{
							$scope.User=response.data;
							$rootScope.currentUser=$scope.User;
							console.log($rootScope.User);
							$location.path("/");
						});
			}
		
			});