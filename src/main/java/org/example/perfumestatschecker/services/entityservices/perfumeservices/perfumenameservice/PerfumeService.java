package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumenameservice;

import org.example.perfumestatschecker.dtos.PerfumeDto;
import org.example.perfumestatschecker.models.perfume.Brand;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PerfumeService {
	@Transactional
	Perfume findOrCreatePerfume(String name, Brand brand);
	
	@Transactional
	List<PerfumeDto> getAllPerfumeNames();
}
