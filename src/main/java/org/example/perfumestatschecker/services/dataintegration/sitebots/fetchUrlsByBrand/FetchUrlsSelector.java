package org.example.perfumestatschecker.services.dataintegration.sitebots.fetchUrlsByBrand;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FetchUrlsSelector {
	private final Map<String,FetchUrlsStrategy> strategies;
	
	public FetchUrlsSelector(List<FetchUrlsStrategy> strategyList) {
		strategies = new HashMap<>();
		strategyList.forEach(
				strategy -> strategies.put(strategy.getClass().getAnnotation(Component.class).value() , strategy)
		);
	}
	
	public FetchUrlsStrategy selectStrategy(String url){
		if(url.contains("notino")){
			return strategies.get("NotinoFetchUrlsByBrand");
		}else if(url.contains("douglas")){
			return strategies.get("DouglasFetchUrlsByBrand");
		}else if(url.contains("parfum.bg")){
			return strategies.get("ParfumBgFetchUrlsByBrand");
		}else{
			throw new IllegalArgumentException("Component is nowhere to be found?");
		}
	}
}
