package org.example.perfumestatschecker.services.entityservices.perfumeservices.brandservice;

import org.example.perfumestatschecker.models.perfume.Brand;
import org.example.perfumestatschecker.repositories.perfume.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService{
	
	private final BrandRepository brandRepository;
	
	@Autowired
	public BrandServiceImpl(BrandRepository brandRepository){
		this.brandRepository = brandRepository;
	}
	
	@Override
	public Brand findOrCreate(String brandname){
		Optional<Brand> brandOptional = brandRepository.findByName(brandname);
		if(brandOptional.isPresent()){
			return brandOptional.get();
		}else{
			Brand brand  = new Brand();
			brand.setName(brandname);
			return brandRepository.save(brand);
		}
		
	}
}
