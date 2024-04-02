package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumetypeservice;

import org.assertj.core.api.Assertions;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.example.perfumestatschecker.models.perfume.PerfumeType;
import org.example.perfumestatschecker.repositories.perfume.PerfumeTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class PerfumeTypeServiceImplTest {
	@Mock
	private PerfumeTypeRepository perfumeTypeRepository;
	
	@InjectMocks
	private PerfumeTypeServiceImpl perfumeTypeService;
	
	@BeforeEach
	void setUp() {
	}
	
	@Test
	public void findOrCreatePerfume_presentPerfumeType_ReturnPerfumeType(){
		String perfumeTypeName = "EDT";
		Optional<PerfumeType> perfumeTypeOptional = Optional.of(new PerfumeType());
		perfumeTypeOptional.get().setName(perfumeTypeName);
		when(perfumeTypeRepository.findByName(perfumeTypeName)).thenReturn(perfumeTypeOptional);
		
		//Act
		PerfumeType savedPerfume = perfumeTypeService.findOrCreatePerfumeType(perfumeTypeName);
		
		//Assert
		Assertions.assertThat(savedPerfume).isNotNull();
		Assertions.assertThat(savedPerfume.getName()).isEqualTo("EDT");
	
	}
	
	@Test
	public void findOrCreatePerfume_NotPresentPerfumeType_ReturnPerfumeType(){
		String perfumeTypeName= "EDT";
		when(perfumeTypeRepository.findByName(perfumeTypeName)).thenReturn(Optional.empty());
		PerfumeType returnedPerfumeType = new PerfumeType("EDT");
		when(perfumeTypeRepository.save(Mockito.any(PerfumeType.class))).thenReturn(returnedPerfumeType);
		//ACT
		PerfumeType savedPerfumeType = perfumeTypeService.findOrCreatePerfumeType(perfumeTypeName);

		Assertions.assertThat(savedPerfumeType).isNotNull();
		Assertions.assertThat(savedPerfumeType.getName()).isEqualTo("EDT");
	}
	
	@Test
	public void findOrCreatePerfume_NullConstraints_ReturnException(){
		String perfumeTypeName = null;
		assertThrows(IllegalArgumentException.class, ()-> perfumeTypeService.findOrCreatePerfumeType(perfumeTypeName));
	}
	@Test
	public void findOrCreatePerfume_EmptyConstraints_ReturnException(){
		String perfumeTypeName = "";
		assertThrows(IllegalArgumentException.class, ()-> perfumeTypeService.findOrCreatePerfumeType(perfumeTypeName));
	}
	@Test
	public void findOrCreatePerfume_MissingConstraints_ReturnException(){
		String perfumeTypeName = " ";
		assertThrows(IllegalArgumentException.class, ()-> perfumeTypeService.findOrCreatePerfumeType(perfumeTypeName));
	}
	
}