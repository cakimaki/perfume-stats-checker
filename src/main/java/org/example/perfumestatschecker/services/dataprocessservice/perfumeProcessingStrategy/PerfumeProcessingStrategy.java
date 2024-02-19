package org.example.perfumestatschecker.services.dataprocessservice.perfumeProcessingStrategy;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;

public interface PerfumeProcessingStrategy {
	public FilteredPerfumeDto processAndSavePerfumeData(String jsonResponse);
}
