package com.demoKafkaAndCouchbase.KafkaCouchbase.Repository;

import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.DynamicProxyable;
import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.stereotype.Repository;
import com.couchbase.client.java.query.QueryScanConsistency;
import com.demoKafkaAndCouchbase.KafkaCouchbase.Entity.JsonMessenger;

@Repository()
@Scope("Kafka")
@Collection("demo")
@ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
public interface SendMessRepository
		extends CouchbaseRepository<JsonMessenger, String>, DynamicProxyable<SendMessRepository> {

}
