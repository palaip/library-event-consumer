package com.itc.consumer.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LibraryEventCosumer {

	@KafkaListener(topics = { "library-events" },groupId = "myGroup")
	public void onMessage(ConsumerRecord<Integer, String> consumerRecord) {

		log.info("consumer record " + consumerRecord);

	}

}
