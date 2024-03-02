package org.example.perfumestatschecker.services.entityservices.offerservice.site;

import org.example.perfumestatschecker.models.offer.Site;
import org.example.perfumestatschecker.repositories.offer.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SiteServiceImpl implements SiteService{
	private final SiteRepository siteRepository;
	
	
	@Autowired
	public SiteServiceImpl(SiteRepository siteRepository) {
		this.siteRepository = siteRepository;
	}
	
	@Transactional
	@Override
	public Site createOrUpdateSite(String siteName){
		Optional<Site> SiteOpt = siteRepository.findByName(siteName);
		
		if(SiteOpt.isPresent()){
			return SiteOpt.get();
		}else{
			Site newSite = new Site();
			newSite.setName(siteName);
			return siteRepository.save(newSite);
		}
	}
}
