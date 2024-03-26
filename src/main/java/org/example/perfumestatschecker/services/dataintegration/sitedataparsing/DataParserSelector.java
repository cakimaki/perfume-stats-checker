package org.example.perfumestatschecker.services.dataintegration.sitedataparsing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataParserSelector {
	private final Map<String, DataParsingStrategy> strategies;
	
	
	//the dependencies created are as follows
	//HashMap is being created (strategies)
	//with String (name of the @Component) and DataParsingStrategy (the Object class)
	//so when calling selectStrategy it searches for the Component name,
	//and it returns the DataParsingStrategy component needed
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
			return strategies.get("ParfumBgProcessingStrategy");
		}else if(url.contains("parfium.bg")){
			return strategies.get("ParfiumBgProcessingStrategy");
		}
		throw new IllegalArgumentException("No strategy found for URL: " + url);
	}
}
