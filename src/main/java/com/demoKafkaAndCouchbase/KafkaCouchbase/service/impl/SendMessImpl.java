package com.demoKafkaAndCouchbase.KafkaCouchbase.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.demoKafkaAndCouchbase.KafkaCouchbase.Entity.JsonMessenger;
import com.demoKafkaAndCouchbase.KafkaCouchbase.Repository.SendMessRepository;
import com.demoKafkaAndCouchbase.KafkaCouchbase.service.SendMessService;

@Service
public class SendMessImpl implements SendMessService {

	private final SendMessRepository repository;

	public SendMessImpl(SendMessRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public JsonMessenger send(String TOPIC_NAME, KafkaTemplate<String, JsonMessenger> kafka, String mess) {

		String UID = UUID.randomUUID().toString();

		JsonMessenger json = new JsonMessenger();
		json.setId(UID);
		json.setMess(mess);
		json.setTimesend(new Date());

		kafka.send(TOPIC_NAME, json);

		return repository.save(json);
	}

	@Override
	public List<JsonMessenger> findAll() {		
		return repository.findAll();
	}

}
