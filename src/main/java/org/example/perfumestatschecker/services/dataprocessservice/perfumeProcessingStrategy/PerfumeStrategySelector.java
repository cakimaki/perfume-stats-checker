package org.example.perfumestatschecker.services.dataprocessservice.perfumeProcessingStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PerfumeStrategySelector {
	private final Map<String,PerfumeProcessingStrategy> strategies;
	
	@Autowired
	public PerfumeStrategySelector(List<PerfumeProcessingStrategy> strategyList){
		strategies = new HashMap<>();
		strategyList.forEach(
				strategy -> strategies.put(strategy.getClass().getAnnotation(Component.class).value(),strategy));
	}
	
	public PerfumeProcessingStrategy selectStrategy(String url) {
		// Logic to choose the appropriate strategy based on the URL
		if (url.contains("notino")) {
			return strategies.get("NotinoProcessingStrategy");
		} else if (url.contains("douglas")) {
			return strategies.get("DouglasProcessingStrategy");
		}
		throw new IllegalArgumentException("No strategy found for URL: " + url);
	}
}
