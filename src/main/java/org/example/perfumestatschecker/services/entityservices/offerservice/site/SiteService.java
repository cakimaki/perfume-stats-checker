package org.example.perfumestatschecker.services.entityservices.offerservice.site;

import org.example.perfumestatschecker.models.offer.Site;
import org.springframework.transaction.annotation.Transactional;

public interface SiteService {
	@Transactional
	Site createOrUpdateSite(String siteName);
}
