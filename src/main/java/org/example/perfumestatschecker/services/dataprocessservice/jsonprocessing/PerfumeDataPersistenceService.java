package org.example.perfumestatschecker.services.dataprocessservice.jsonprocessing;


import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;

import java.util.List;

public interface PerfumeDataPersistenceService {
	public void persistFilteredPerfumeData(List<FilteredPerfumeDto> dtos);
}
