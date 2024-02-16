package org.example.perfumestatschecker.services.brandservice;

import org.example.perfumestatschecker.models.Brand;
import org.example.perfumestatschecker.repositories.BrandRepository;
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
	
	public Brand findOrCreate(String brandname){
		Optional<Brand> brandOptional = brandRepository.findByName(brandname);
		if(brandOptional.isPresent()){
			return brandOptional.get();
		}else{
			Bran
		}
		
	}
}
