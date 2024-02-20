package org.example.perfumestatschecker.services.entityservices.perfumetypeservice;

import org.example.perfumestatschecker.models.perfume.PerfumeType;

public interface PerfumeTypeService{
	
	PerfumeType findOrCreatePerfumeType(String PerfumeType);
}
