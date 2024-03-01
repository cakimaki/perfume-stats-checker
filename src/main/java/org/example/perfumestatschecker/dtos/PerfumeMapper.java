package org.example.perfumestatschecker.dtos;

import org.example.perfumestatschecker.dtos.getdtos.PerfumeVariantDetailsDto;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.example.perfumestatschecker.models.perfume.PerfumeVariant;
import org.springframework.stereotype.Component;

@Component
public class PerfumeMapper {
	
	public PerfumeVariantDetailsDto convertToDto(PerfumeVariant perfumeVariant){
		PerfumeVariantDetailsDto dto = new PerfumeVariantDetailsDto();
		dto.setPerfumeName(perfumeVariant.getPerfume().getName());
		dto.setBrandName(perfumeVariant.getPerfume().getBrand().getName());
		dto.setType(perfumeVariant.getType().getName());
		dto.setVolume(perfumeVariant.getVolume().getName());
		
		return dto;
	}
	
	public PerfumeDto convertToDto(Perfume perfume){
		PerfumeDto dto = new PerfumeDto();
		dto.setId(perfume.getId());
		dto.setPerfumeName(perfume.getName());
		
		return dto;
	}
}
