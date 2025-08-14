package com.itc.consumer.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.itc.consumer.kafka.service.LibraryEventService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LibraryEventCosumer {

	@Autowired
	private LibraryEventService libraryService;

	@KafkaListener(topics = { "library-events" }, groupId = "myGroup")
	public void onMessage(ConsumerRecord<Integer, String> consumerRecord)
			throws JsonMappingException, JsonProcessingException {

		log.info("consumer record consumeed ***** " + consumerRecord);
		/*
		 * after consuming the a message from topic it should be saved into the db 
		 */

	//	libraryService.processLibraryEvent(consumerRecord);

	}

}
