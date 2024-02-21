package org.example.perfumestatschecker.services.dataintegration;

import org.springframework.transaction.annotation.Transactional;

public interface PerfumeDataProcessingPipelineService {
	@Transactional
	void processAndSavePerfumeDataFromUrl(String url);
}
