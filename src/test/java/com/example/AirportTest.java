package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import com.example.dao.AirportRepository;
import com.example.entities.Airport;
import com.example.service.AirportServiceImpl;


@ExtendWith(MockitoExtension.class)
class AirportTest {
@Mock
	private AirportRepository repository;
@InjectMocks
	private AirportServiceImpl AirportService;

	@Test
	void viewAllAirportTest() {

	List<Airport> list = new ArrayList<Airport>();
	Airport airport = new Airport("AirIndia","Bangalore","1");
	list.add(airport);
	
	when(repository.findAll()).thenReturn(list);
	List<Airport> airportList = (List<Airport>) AirportService.viewAllAirport();
	assertEquals(1,airportList.size());
	}
	
	@Test
	void saveAirportTest() {
		Airport airport = new Airport("AirIndia","Bangalore","1");
		when(repository.save(airport)).thenReturn(airport);
		ResponseEntity<Airport> savedAirport = AirportService.addAirport(airport);
		assertThat(savedAirport).isNotNull();
	
	}
	
}
	
