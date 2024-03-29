package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumevolumeservice;

import org.example.perfumestatschecker.models.perfume.PerfumeVolume;
import org.example.perfumestatschecker.repositories.perfume.PerfumeVolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfumeVolumeServiceImpl implements PerfumeVolumeService{
	
	
	private final PerfumeVolumeRepository perfumeVolumeRepository;
	
	@Autowired
	public PerfumeVolumeServiceImpl(PerfumeVolumeRepository perfumeVolumeRepository){
		this.perfumeVolumeRepository = perfumeVolumeRepository;
	}
	
	@Override
	public PerfumeVolume findOrCreateVolume(String volumename){
		if(volumename == null ||volumename.isEmpty() || volumename.equals(" ")){
			throw new IllegalArgumentException("volume name is empty or ' '");
		}
		Optional<PerfumeVolume> optionalPerfumeVolume = perfumeVolumeRepository.findByName(volumename);
		if(optionalPerfumeVolume.isPresent()){
			return optionalPerfumeVolume.get();
		}else{
			PerfumeVolume perfumeVolume = new PerfumeVolume();
			perfumeVolume.setName(volumename);
			return perfumeVolumeRepository.save(perfumeVolume);
		}
	}
	
}
