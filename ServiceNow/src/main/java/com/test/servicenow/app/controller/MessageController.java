package com.test.servicenow.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.test.servicenow.app.model.Message;
import com.test.servicenow.app.repository.MessageRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class MessageController {
	
	@Autowired
	private MessageRepo msgRepo;
    
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @GetMapping("/api/messages/list")
    public List<Message> GetAllMessages(Message message, Pageable pageable) {
    	 Page listOfMsgs  = msgRepo.findAll(pageable);
        return listOfMsgs.getContent();
    }
    
    @GetMapping("/api/message/search/{content}")
    public List<Message> SearchMessages(@PathVariable String content, Pageable pageable ){
    	Page listOfMsgs =   msgRepo.findByContentContainsAllIgnoreCase( content, pageable) ;    	
    	return listOfMsgs.getContent();
    }
    
    
}
