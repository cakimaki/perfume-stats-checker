package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumeservice;


import org.example.perfumestatschecker.models.perfume.Brand;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.example.perfumestatschecker.models.perfume.PerfumeType;
import org.example.perfumestatschecker.models.perfume.PerfumeVolume;
import org.example.perfumestatschecker.repositories.perfume.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PerfumeServiceImpl implements PerfumeService {
	@Autowired
	private PerfumeRepository perfumeRepository;
	
	public boolean perfumeExists(String name, Brand brand, PerfumeType type, PerfumeVolume volume) {
		Optional<Perfume> existingPerfume = perfumeRepository.findByNameAndVolumeAndType(name, brand, type, volume);
		return existingPerfume.isPresent();
	}
	
	@Transactional
	@Override
	public Perfume findOrCreatePerfume(String name, Brand brand, PerfumeType type, PerfumeVolume volume){
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
}
