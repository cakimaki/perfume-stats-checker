package org.example.perfumestatschecker.services.dataintegration.storingdata;


import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;

import java.util.List;

public interface PerfumeDataSavingService {
	public void persistFilteredPerfumeData(List<FilteredPerfumeDto> dtos);
}
