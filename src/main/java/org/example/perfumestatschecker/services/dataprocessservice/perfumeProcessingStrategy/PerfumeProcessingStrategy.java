package org.example.perfumestatschecker.services.dataprocessservice.perfumeProcessingStrategy;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;

import java.util.List;

public interface PerfumeProcessingStrategy {
	public List<FilteredPerfumeDto> processAndSavePerfumeData(String jsonResponse);
}
