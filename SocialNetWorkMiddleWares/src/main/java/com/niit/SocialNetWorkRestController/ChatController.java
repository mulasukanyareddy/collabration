package com.niit.SocialNetWorkRestController;

	import java.util.Date;

	import org.springframework.messaging.handler.annotation.MessageMapping;
	import org.springframework.messaging.handler.annotation.SendTo;
	import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialNetwork.model.Message;
import com.niit.SocialNetwork.model.OutputMessage;


	@RestController
	public class ChatController 
	{
		@MessageMapping("/chat")
		@SendTo("/topic/message")
		public OutputMessage sendMessage(Message message)
		{
			return new OutputMessage(message,new Date());
		}
	}


