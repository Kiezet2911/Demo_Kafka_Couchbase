package com.demoKafkaAndCouchbase.KafkaCouchbase.Entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class JsonMessenger {
	@Id
	private String id;
	@Field(name = "mess")
	private String mess;
	@Field(name = "timesend")
	private Date timesend;

	public JsonMessenger(String id, String mess, Date timesend) {
		super();
		this.id = id;
		this.mess = mess;
		this.timesend = timesend;
	}

	public JsonMessenger() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public Date getTimesend() {
		return timesend;
	}

	public void setTimesend(Date timesend) {
		this.timesend = timesend;
	}

}
