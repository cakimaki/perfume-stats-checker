package org.example.perfumestatschecker.services.entityservices.perfumeservice;

import org.example.perfumestatschecker.models.Brand;
import org.example.perfumestatschecker.models.Perfume;
import org.example.perfumestatschecker.models.PerfumeType;
import org.example.perfumestatschecker.models.PerfumeVolume;
import org.springframework.transaction.annotation.Transactional;

public interface PerfumeService {
	@Transactional
	Perfume findOrCreatePerfume(String name, Brand brand, PerfumeType type, PerfumeVolume volume);
}
