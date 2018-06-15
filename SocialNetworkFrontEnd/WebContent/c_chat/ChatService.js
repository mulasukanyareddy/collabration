myApp.service('chatService',function($q,$timeout)
		{
	service.RECONNECT_TIMEOUT=30000;
	var base_url ="http://localhost:"
		service.SOCKET_URL=base_url+"/chat";
	var service={},listener=$q.defer(),socket={client:null,stomp:null},messageIds=[];
	service.CHAT_TOPIC="/topic/message";
	service.CHAT_BROKER="/app/chat";
	service.send = function(message)
	{
		
		var id=math.floor(math.random()*100000);
	//	socket.stomp.send(servicd.CHAT_BROKER,{priority:9},JSON.stringify({message:message,id:id}));
	//	message Ids.push(id);
	};
	service.receive=function()
	{
	
	};
	var reconnect=function()
	{
		
			
			$timout(function()
					{
				
					initialize()
					},RECONNECT_TIMEOUT);
	};
	
	var getMessage=function(data)
	{
		
	};
	var StarListener=function()
	{
		
	};
	var initialize=function()
	{
		socket.client=new SockJs(service.SOCKET_URL);
		socket.stomp = Stomp.over(socket.client);
		socket.stomp.connect(StartListener);
		socket.stomp.onclose=reconnect;
	};
		});

	