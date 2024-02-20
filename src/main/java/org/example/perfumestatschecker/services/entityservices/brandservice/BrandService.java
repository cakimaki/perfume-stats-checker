package org.example.perfumestatschecker.services.entityservices.brandservice;

import org.example.perfumestatschecker.models.perfume.Brand;

public interface BrandService  {
	Brand findOrCreate(String brandname);
}
