package com.test.servicenow.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.servicenow.app.model.Message;

@Repository
public interface MessageRepo extends PagingAndSortingRepository <Message, Long> {
	
	Page<Message> findAll(Pageable pageable);	
	
	Page<Message> findByContentContainsAllIgnoreCase( @Param("content") String Content, Pageable pageable);
	
}
