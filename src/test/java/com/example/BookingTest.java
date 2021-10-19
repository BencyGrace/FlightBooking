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
import com.example.dao.BookingRepository;
import com.example.entities.Booking;
import com.example.service.BookingServiceImpl;


@ExtendWith(MockitoExtension.class)
class BookingTest {
@Mock
	private BookingRepository repository;
@InjectMocks
	private BookingServiceImpl BookingService;
BigInteger bookingId=BigInteger.valueOf(1L);
	@Test
	void viewAllBookingTest() {

	List<Booking> list = new ArrayList<Booking>();
	Booking booking = new Booking(bookingId,"12-10-2021",6);
	list.add(booking);
	
	when(repository.findAll()).thenReturn(list);
	List<Booking> bookingList = (List<Booking>) BookingService.displayAllBooking();
	assertEquals(1,bookingList.size());
	}
	
	@Test
	void saveBookingTest() {
		Booking booking = new Booking(bookingId,"12-10-2021",6);
		when(repository.save(booking)).thenReturn(booking);
		ResponseEntity<Booking> savedBooking = BookingService.createBooking(booking);
		assertThat(savedBooking).isNotNull();
	
	}
	
}



