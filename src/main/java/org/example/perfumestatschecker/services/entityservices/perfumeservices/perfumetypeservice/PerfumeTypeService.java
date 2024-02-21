package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumetypeservice;

import org.example.perfumestatschecker.models.perfume.PerfumeType;

public interface PerfumeTypeService{
	
	PerfumeType findOrCreatePerfumeType(String PerfumeType);
}
