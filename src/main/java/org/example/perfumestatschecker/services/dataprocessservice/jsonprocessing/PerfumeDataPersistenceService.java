package org.example.perfumestatschecker.services.dataprocessservice.jsonprocessing;


import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;

public interface PerfumeDataPersistenceService {
	public void persistFilteredPerfumeData(FilteredPerfumeDto dto);
}
