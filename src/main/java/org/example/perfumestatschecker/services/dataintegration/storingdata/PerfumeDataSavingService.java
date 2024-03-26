package org.example.perfumestatschecker.services.dataintegration.storingdata;


import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;

import java.util.List;

public interface PerfumeDataSavingService {
	void persistFilteredPerfumeData(List<FilteredPerfumeDto> dtos);
}
