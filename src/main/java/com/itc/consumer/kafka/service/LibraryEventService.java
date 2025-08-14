package com.itc.consumer.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itc.consumer.kafka.entity.LibraryEvent;
import com.itc.consumer.kafka.repository.LibraryEventRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LibraryEventService {

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	private LibraryEventRepo eventRepo;

	public void processLibraryEvent(ConsumerRecord<Integer, String> consumerRecord)
			throws JsonMappingException, JsonProcessingException {

		LibraryEvent libraryEvent = objectMapper.readValue(consumerRecord.value(), LibraryEvent.class);

		log.info("library event **** ###{}", libraryEvent);

		switch (libraryEvent.getLibraryEventType()) {
		case NEW: {

			save(libraryEvent);
			log.info("successfully persist library event");
			break;

		}

		case UPDATE: {

			// eventRepo.sa

			break;

		}
		default:
			log.info("Invalid event type ");
		}

	}

	private void save(LibraryEvent libraryEvent) {
		
		log.info(" ***** libraryevent book authorName ** " + libraryEvent.getBook().getBookName());

		libraryEvent.getBook().setLibraryEvent(libraryEvent);
		
		log.info("library event **** ### before saved {} ", libraryEvent);
		
		eventRepo.save(libraryEvent);

	}

}
