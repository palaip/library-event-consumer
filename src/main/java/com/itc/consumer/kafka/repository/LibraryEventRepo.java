package com.itc.consumer.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.consumer.kafka.entity.LibraryEvent;

public interface LibraryEventRepo extends JpaRepository<LibraryEvent, Integer> {

	
	
}
