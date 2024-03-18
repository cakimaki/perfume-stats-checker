package org.example.perfumestatschecker.services.dataintegration.sitedataparsing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataParserSelector {
	private final Map<String, DataParsingStrategy> strategies;
	
	@Autowired
	public DataParserSelector(List<DataParsingStrategy> strategyList){
		strategies = new HashMap<>();
		strategyList.forEach(
				strategy -> strategies.put(strategy.getClass().getAnnotation(Component.class).value(),strategy));
	}
	
	public DataParsingStrategy selectStrategy(String url) {
		// Logic to choose the appropriate strategy based on the URL
		if (url.contains("notino")) {
			return strategies.get("NotinoProcessingStrategy");
		} else if (url.contains("douglas")) {
			return strategies.get("DouglasProcessingStrategy");
		}else if(url.contains("parfum.bg")){
			return strategies.get("ParfiumBgProcessingStrategy");
		}
		throw new IllegalArgumentException("No strategy found for URL: " + url);
	}
}
