package org.example.perfumestatschecker.services.entityservices.perfumevolumeservice;

import org.example.perfumestatschecker.models.perfume.PerfumeVolume;

public interface PerfumeVolumeService {
	PerfumeVolume findOrCreateVolume(String volumename);
}
