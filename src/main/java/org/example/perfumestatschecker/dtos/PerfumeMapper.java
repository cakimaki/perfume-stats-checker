package org.example.perfumestatschecker.dtos;

import org.example.perfumestatschecker.dtos.getdtos.PerfumeDetailsDto;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.example.perfumestatschecker.models.perfume.PerfumeName;
import org.springframework.stereotype.Component;

@Component
public class PerfumeMapper {
	
	public PerfumeDetailsDto convertToDto(Perfume perfume){
		PerfumeDetailsDto dto = new PerfumeDetailsDto();
		dto.setPerfumeName(perfume.getName().getName());
		dto.setBrandName(perfume.getBrand().getName());
		dto.setType(perfume.getType().getName());
		dto.setVolume(perfume.getVolume().getName());
		
		return dto;
	}
	
	public PerfumeNameDto convertToDto(PerfumeName perfumeName){
		PerfumeNameDto dto = new PerfumeNameDto();
		dto.setId(perfumeName.getId());
		dto.setPerfumeName(perfumeName.getName());
		
		return dto;
	}
}
