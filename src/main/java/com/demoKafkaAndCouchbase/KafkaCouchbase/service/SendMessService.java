package com.demoKafkaAndCouchbase.KafkaCouchbase.service;

import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;

import com.demoKafkaAndCouchbase.KafkaCouchbase.Entity.JsonMessenger;

public interface SendMessService {
	JsonMessenger send(String TOPIC_NAME, KafkaTemplate<String, JsonMessenger> kafka, String mess);

	List<JsonMessenger> findAll();
}
