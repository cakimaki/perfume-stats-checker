package org.example.perfumestatschecker.services.dataintegration.sitebots.fetchUrlsByBrand;

import java.util.List;

public interface FetchUrlsStrategy {
	
	List<String> fetchPerfumeUrlsByBrand(String brand) throws InterruptedException;
}
