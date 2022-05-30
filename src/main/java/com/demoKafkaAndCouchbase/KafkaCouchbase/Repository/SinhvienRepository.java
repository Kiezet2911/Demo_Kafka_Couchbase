package com.demoKafkaAndCouchbase.KafkaCouchbase.Repository;

import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.DynamicProxyable;
import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.stereotype.Repository;

import com.couchbase.client.java.query.QueryScanConsistency;
import com.demoKafkaAndCouchbase.KafkaCouchbase.Entity.Sinhvien;

@Repository()
@Scope("Sinhvien")
@Collection("demo")
@ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
public interface SinhvienRepository extends CouchbaseRepository<Sinhvien, String>, DynamicProxyable<SinhvienRepository> {
	
}
