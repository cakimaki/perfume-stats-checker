package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumenameservice;

import org.example.perfumestatschecker.dtos.PerfumeMapper;
import org.example.perfumestatschecker.dtos.PerfumeNameDto;
import org.example.perfumestatschecker.models.perfume.PerfumeName;
import org.example.perfumestatschecker.repositories.perfume.PerfumeNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PerfumeNameServiceImpl implements PerfumeNameService {
	private final PerfumeNameRepository perfumeNameRepository;
	private final PerfumeMapper perfumeMapper;
	@Autowired
	public PerfumeNameServiceImpl(PerfumeNameRepository perfumeNameRepository, PerfumeMapper perfumeMapper) {
		this.perfumeNameRepository = perfumeNameRepository;
		this.perfumeMapper = perfumeMapper;
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
	
	@Override
	@Transactional
	public List<PerfumeNameDto> getAllPerfumeNames(){
		return perfumeNameRepository.findAll().stream().map(perfumeMapper::convertToDto).collect(Collectors.toList());
		
	}
}
