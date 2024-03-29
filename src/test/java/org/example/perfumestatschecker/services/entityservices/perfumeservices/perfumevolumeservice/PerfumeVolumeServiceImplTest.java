package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumevolumeservice;

import org.assertj.core.api.Assertions;
import org.example.perfumestatschecker.models.perfume.PerfumeVolume;
import org.example.perfumestatschecker.repositories.perfume.PerfumeVolumeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PerfumeVolumeServiceImplTest {
	@Mock
	private PerfumeVolumeRepository perfumeVolumeRepository;
	@InjectMocks
	private PerfumeVolumeServiceImpl perfumeVolumeService;
	@BeforeEach
	void setUp() {
	
	}
	
	@Test
	public void findOrCreateVolume_ReturnsPerfumeVolume(){
		//arrange
		String volumeName = "30";
		Optional<PerfumeVolume> optionalPerfumeVolume = Optional.of(new PerfumeVolume("30"));
		when(perfumeVolumeRepository.findByName(volumeName)).thenReturn(optionalPerfumeVolume);
		
		//act
		PerfumeVolume savedVolume = perfumeVolumeService.findOrCreateVolume(volumeName);
		
		//assert
		Assertions.assertThat(savedVolume).isNotNull();
		//not corresponding because optionalPerfumeVolume is another address of object
		//Assertions.assertThat(savedVolume).isEqualTo(optionalPerfumeVolume);
		Assertions.assertThat(savedVolume.getName()).isEqualTo("30");
	}
	
	@Test
	public void findOrCreateVolume_whenVolumeNotFound_ReturnsVolume(){
		//Arrange
		String volumeName = "30";
		Optional<PerfumeVolume> optionalPerfumeVolume = Optional.of(new PerfumeVolume("30"));
		PerfumeVolume perfumeVolume = new PerfumeVolume("30");
		when(perfumeVolumeRepository.findByName(volumeName)).thenReturn(Optional.empty());
		when(perfumeVolumeRepository.save(Mockito.any(PerfumeVolume.class))).thenReturn(perfumeVolume);
		
		//Act
		PerfumeVolume savedVolume = perfumeVolumeService.findOrCreateVolume(volumeName);
		
		//Assert
		Assertions.assertThat(savedVolume).isNotNull();
		//Assertions.assertThat(savedVolume).isEqualTo(optionalPerfumeVolume);
		Assertions.assertThat(savedVolume.getName()).isEqualTo("30");
	}
	
	
}