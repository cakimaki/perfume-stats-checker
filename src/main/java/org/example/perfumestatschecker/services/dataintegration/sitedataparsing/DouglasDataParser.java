package org.example.perfumestatschecker.services.dataintegration.sitedataparsing;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.services.dataintegration.sitedataparsing.DataParsingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("DouglasProcessingStrategy")
public class DouglasDataParser implements DataParsingStrategy {

/*
todo---------------------------------
todo ---- NOT YET IMPLEMENTED ------
todo---------------------------------
*/

	@Override
	public List<FilteredPerfumeDto> parseDataStringIntoObject(String jsonResponse){
		return null;
		
	}

}

