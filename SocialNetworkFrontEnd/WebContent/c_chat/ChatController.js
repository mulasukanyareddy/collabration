myApp.controller("ChatController",function($scope,$http,$rootScope,chatService)
		{
	$scope.messages=[];
	$scope.message="";
	$scope.max=140;
	$scope.addMessage=function()
	{
		alert("chat module-Add Message");
		chatService.send($rootScope.currentUser.loginname+":"+$scope.message);
		$scope.message="";
	}
	chatService.receive().then (null, null, function (message)
{
		$scope.messages.push(message);
});
	
	alert("Hello-Chat Module"); 
			
		});