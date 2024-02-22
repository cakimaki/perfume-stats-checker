package org.example.perfumestatschecker.dtos;

import org.example.perfumestatschecker.dtos.getdtos.PerfumeDetailsDto;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.springframework.stereotype.Component;

@Component
public class PerfumeMapper {
	
	public PerfumeDetailsDto convertToDto(Perfume perfume){
		PerfumeDetailsDto dto = new PerfumeDetailsDto();
		dto.setPerfumeName(perfume.getName());
		dto.setBrandName(perfume.getBrand().getName());
		dto.setType(perfume.getType().getName());
		dto.setVolume(perfume.getVolume().getName());
		
		return dto;
	}
}
