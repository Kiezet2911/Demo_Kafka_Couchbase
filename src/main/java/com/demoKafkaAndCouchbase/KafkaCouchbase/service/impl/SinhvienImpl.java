package com.demoKafkaAndCouchbase.KafkaCouchbase.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.demoKafkaAndCouchbase.KafkaCouchbase.Entity.Sinhvien;
import com.demoKafkaAndCouchbase.KafkaCouchbase.Repository.SinhvienRepository;
import com.demoKafkaAndCouchbase.KafkaCouchbase.service.SinhvienService;

@Service
public class SinhvienImpl implements SinhvienService {
	private final SinhvienRepository sinhvienRepository;

	public SinhvienImpl(SinhvienRepository sinhvienRepository) {
		this.sinhvienRepository = sinhvienRepository;
	}

	@Override
	public List<Sinhvien> findAllList() {
		return sinhvienRepository.findAll();
	}

	@Override
	public Optional<Sinhvien> findById(String id) {
		Optional<Sinhvien> sv = sinhvienRepository.findById(id);
		return sv;
	}

	@Override
	public Sinhvien insert(Sinhvien sinhvien) {

		Sinhvien sv = new Sinhvien();

		sv.setId(UUID.randomUUID().toString());
		sv.setName(sinhvien.getName());
		sv.setLop(sinhvien.getLop());

		return sinhvienRepository.save(sv);
	}

	@Override
	public Sinhvien update(Sinhvien sinhvien) {
		return sinhvienRepository.save(sinhvien);
	}

	@Override
	public void delete(String id) {
		sinhvienRepository.deleteById(id);
	}

}
