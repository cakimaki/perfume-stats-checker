package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumeservice;


import org.example.perfumestatschecker.dtos.getdtos.PerfumeDetailsDto;
import org.example.perfumestatschecker.dtos.PerfumeMapper;
import org.example.perfumestatschecker.models.perfume.*;
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
	public PerfumeServiceImpl(PerfumeRepository perfumeRepository, PerfumeMapper perfumeMapper){
		this.perfumeRepository=perfumeRepository;
		this.perfumeMapper = perfumeMapper;
	}
	public boolean perfumeExists(PerfumeName name, Brand brand, PerfumeType type, PerfumeVolume volume) {
		Optional<Perfume> existingPerfume = perfumeRepository.findByNameAndVolumeAndType(name, brand, type, volume);
		return existingPerfume.isPresent();
	}
	
	@Transactional
	@Override
	public Perfume findOrCreatePerfume(PerfumeName name, Brand brand, PerfumeType type, PerfumeVolume volume){
		Optional<Perfume> existingPerfume = perfumeRepository.findByNameAndVolumeAndType(name,brand,type,volume);
		if (existingPerfume.isPresent()) {
			// Return the existing perfume if found
			return existingPerfume.get();
		} else {
			// Create a new perfume instance if not found
			Perfume newPerfume = new Perfume();
			newPerfume.setName(name);
			newPerfume.setBrand(brand);
			newPerfume.setType(type);
			newPerfume.setVolume(volume);
			// Save the new perfume to the database
			return perfumeRepository.save(newPerfume);
		}
	}
	
	
	@Override
	public List<PerfumeDetailsDto> getAllPerfumesDetails(){
		return perfumeRepository.findAll().stream().map(perfumeMapper::convertToDto).collect(Collectors.toList());
	}
	
	/*public PerfumeDetailsDto getPerfumeById(String name){
	
	}*/
}
