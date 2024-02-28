package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumenameservice;

import org.example.perfumestatschecker.models.perfume.PerfumeName;
import org.example.perfumestatschecker.repositories.perfume.PerfumeNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PerfumeNameServiceImpl implements PerfumeNameService {
	private final PerfumeNameRepository perfumeNameRepository;
	
	@Autowired
	public PerfumeNameServiceImpl(PerfumeNameRepository perfumeNameRepository) {
		this.perfumeNameRepository = perfumeNameRepository;
	}
	
	@Transactional
	@Override
	public PerfumeName findOrCreatePerfumeName(String name){
		Optional<PerfumeName> perfumeNameOptional =  perfumeNameRepository.findByName(name);
		
		if(perfumeNameOptional.isPresent()){
			return perfumeNameOptional.get();
		}else{
			PerfumeName newPerfumeName = new PerfumeName();
			newPerfumeName.setName(name);
			return perfumeNameRepository.save(newPerfumeName);
		}
	}
}
