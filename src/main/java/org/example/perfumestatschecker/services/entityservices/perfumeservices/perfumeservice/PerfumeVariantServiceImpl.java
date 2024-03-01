package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumeservice;


import org.example.perfumestatschecker.dtos.getdtos.PerfumeVariantDetailsDto;
import org.example.perfumestatschecker.dtos.PerfumeMapper;
import org.example.perfumestatschecker.models.perfume.*;
import org.example.perfumestatschecker.repositories.perfume.PerfumeVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.example.perfumestatschecker.models.perfume.Perfume;
@Service
public class PerfumeVariantServiceImpl implements PerfumeVariantService {
	
	private final PerfumeVariantRepository perfumeVariantRepository;
	private final PerfumeMapper perfumeMapper;
	
	@Autowired
	public PerfumeVariantServiceImpl(PerfumeVariantRepository perfumeVariantRepository, PerfumeMapper perfumeMapper){
		this.perfumeVariantRepository = perfumeVariantRepository;
		this.perfumeMapper = perfumeMapper;
	}
	public boolean perfumeExists(Perfume name, Brand brand, PerfumeType type, PerfumeVolume volume) {
		Optional<PerfumeVariant> existingPerfume = perfumeVariantRepository.findByPerfumeAndVolumeAndType(name, type, volume);
		return existingPerfume.isPresent();
	}
	
	@Transactional
	@Override
	public PerfumeVariant findOrCreatePerfumeVariant(Perfume perfume, PerfumeType type, PerfumeVolume volume){
		Optional<PerfumeVariant> existingPerfumeVar = perfumeVariantRepository.findByPerfumeAndVolumeAndType(perfume,type,volume);
		if (existingPerfumeVar.isPresent()) {
			// Return the existing perfume if found
			return existingPerfumeVar.get();
		} else {
			// Create a new perfume instance if not found
			PerfumeVariant newPerfumeVar = new PerfumeVariant();
			newPerfumeVar.setPerfume(perfume);
			newPerfumeVar.setType(type);
			newPerfumeVar.setVolume(volume);
			// Save the new perfume to the database
			return perfumeVariantRepository.save(newPerfumeVar);
		}
	}
	
	
	@Override
	public List<PerfumeVariantDetailsDto> getAllPerfumeVariantsDetails(){
		return perfumeVariantRepository.findAll().stream().map(perfumeMapper::convertToDto).collect(Collectors.toList());
	}
	
	/*public PerfumeDetailsDto getPerfumeById(String name){
	
	}*/
}
