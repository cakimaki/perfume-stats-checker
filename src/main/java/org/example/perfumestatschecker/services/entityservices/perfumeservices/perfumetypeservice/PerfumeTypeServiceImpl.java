package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumetypeservice;

import org.example.perfumestatschecker.models.perfume.PerfumeType;
import org.example.perfumestatschecker.repositories.perfume.PerfumeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfumeTypeServiceImpl implements PerfumeTypeService{
	
	private final PerfumeTypeRepository perfumeTypeRepository;
	
	
	@Autowired
	public PerfumeTypeServiceImpl(PerfumeTypeRepository perfumeTypeRepository) {
		this.perfumeTypeRepository = perfumeTypeRepository;
	}
	
	@Override
	public PerfumeType findOrCreatePerfumeType(String perfumetypename){
		if(perfumetypename == null || perfumetypename.isEmpty() || perfumetypename.equals(" ")){
			throw new IllegalArgumentException("Cannot save perfume type name in the DB because it is null." +"'"+ perfumetypename + "'");
			
		}
		
		Optional<PerfumeType> perfumeTypeOptional = perfumeTypeRepository.findByName(perfumetypename);
		if(perfumeTypeOptional.isPresent()){
			return perfumeTypeOptional.get();
		}else{
			PerfumeType perfumeType = new PerfumeType();
			perfumeType.setName(perfumetypename);
			return perfumeTypeRepository.save(perfumeType);
		}
	}
}
