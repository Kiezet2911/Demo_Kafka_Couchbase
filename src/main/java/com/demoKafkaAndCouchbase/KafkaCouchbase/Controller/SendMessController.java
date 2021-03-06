package com.demoKafkaAndCouchbase.KafkaCouchbase.Controller;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoKafkaAndCouchbase.KafkaCouchbase.Entity.JsonMessenger;
import com.demoKafkaAndCouchbase.KafkaCouchbase.service.SendMessService;

@RestController
@RequestMapping("/send")
public class SendMessController {

	private final KafkaTemplate<String, JsonMessenger> template;
	private final String TOPIC_NAME = "items-topic";
	private final SendMessService service;

	public SendMessController(KafkaTemplate<String, JsonMessenger> template, SendMessService service) {
		super();
		this.template = template;
		this.service = service;
	}

	@GetMapping("/{mess}")
	public JsonMessenger Send(@PathVariable("mess") String mess) {

		return service.send(TOPIC_NAME, template, mess);
	}

	// @GetMapping("/readsend")
	@KafkaListener(topics = "items-topic", groupId = "group-id", containerFactory = "kafkaListenerContainerFactory")
	public void listen(JsonMessenger message) {
		System.out.println("Message: " + message.getMess());
	}

	@GetMapping("/findAll")
	public List<JsonMessenger> findAll() {
		return service.findAll();
	}
}
