package org.example.perfumestatschecker.services.entityservices.perfumeservice;

import org.example.perfumestatschecker.models.perfume.Brand;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.example.perfumestatschecker.models.perfume.PerfumeType;
import org.example.perfumestatschecker.models.perfume.PerfumeVolume;
import org.springframework.transaction.annotation.Transactional;

public interface PerfumeService {
	@Transactional
	Perfume findOrCreatePerfume(String name, Brand brand, PerfumeType type, PerfumeVolume volume);
}
