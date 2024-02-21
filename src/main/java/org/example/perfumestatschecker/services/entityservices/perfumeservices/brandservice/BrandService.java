package org.example.perfumestatschecker.services.entityservices.perfumeservices.brandservice;

import org.example.perfumestatschecker.models.perfume.Brand;

public interface BrandService  {
	Brand findOrCreate(String brandname);
}
