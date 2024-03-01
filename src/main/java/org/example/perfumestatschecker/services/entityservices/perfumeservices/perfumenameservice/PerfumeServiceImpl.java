package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumenameservice;

import org.example.perfumestatschecker.dtos.PerfumeMapper;
import org.example.perfumestatschecker.dtos.PerfumeDto;
import org.example.perfumestatschecker.models.perfume.Brand;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.example.perfumestatschecker.repositories.perfume.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PerfumeServiceImpl implements PerfumeService {
	private final PerfumeRepository perfumeRepository;
	private final PerfumeMapper perfumeMapper;
	@Autowired
	public PerfumeServiceImpl(PerfumeRepository perfumeRepository, PerfumeMapper perfumeMapper) {
		this.perfumeRepository = perfumeRepository;
		this.perfumeMapper = perfumeMapper;
	}
	
	@Transactional
	@Override
	public Perfume findOrCreatePerfume(String name, Brand brand){
		Optional<Perfume> perfumeNameOptional =  perfumeRepository.findByNameAndBrand(name,brand);
		
		if(perfumeNameOptional.isPresent()){
			return perfumeNameOptional.get();
		}else{
			Perfume newPerfume = new Perfume();
			newPerfume.setName(name);
			newPerfume.setBrand(brand);
			return perfumeRepository.save(newPerfume);
		}
	}
	
	@Override
	@Transactional
	public List<PerfumeDto> getAllPerfumeNames(){
		return perfumeRepository.findAll().stream().map(perfumeMapper::convertToDto).collect(Collectors.toList());
		
	}
}
