package com.vaibhav.service;

import java.util.List;

import com.vaibhav.exception.ChatException;
import com.vaibhav.exception.MessageException;
import com.vaibhav.exception.UserException;
import com.vaibhav.model.Message;
import com.vaibhav.request.SendMessageRequest;

public interface MessageService  {
	
	public Message sendMessage(SendMessageRequest req) throws UserException, ChatException;
	
	public List<Message> getChatsMessages(Integer chatId) throws ChatException;
	
	public Message findMessageById(Integer messageId) throws MessageException;
	
	public String deleteMessage(Integer messageId) throws MessageException;

}
