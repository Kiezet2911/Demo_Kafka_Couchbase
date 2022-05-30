package com.demoKafkaAndCouchbase.KafkaCouchbase.Entity;

import org.springframework.data.annotation.*;
import org.springframework.data.couchbase.core.mapping.*;

@Document

public class Sinhvien {
	@Id
	private String id;

	@Field(name = "name")
	private String name;

	@Field(name = "Lop")
	private String Lop;

	public Sinhvien(String id, String name, String Lop) {
		super();
		this.id = id;
		this.name = name;
		this.Lop = Lop;
	}

	public Sinhvien() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLop() {
		return Lop;
	}

	public void setLop(String Lop) {
		this.Lop = Lop;
	}

}
