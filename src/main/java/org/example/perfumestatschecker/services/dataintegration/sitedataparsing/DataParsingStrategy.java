package org.example.perfumestatschecker.services.dataintegration.sitedataparsing;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;

import java.util.List;

public interface DataParsingStrategy {
	public List<FilteredPerfumeDto> parseDataStringIntoObject(String jsonResponse);
}
