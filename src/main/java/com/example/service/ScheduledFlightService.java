package com.example.service;

import java.math.BigInteger;
import com.example.entities.ScheduledFlight;
import com.example.exception.RecordNotFoundException;
import com.example.exception.ScheduledFlightNotFoundException;


public interface ScheduledFlightService {
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight);
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);
	public String removeScheduledFlight(BigInteger id) throws RecordNotFoundException;
	public Iterable<ScheduledFlight> viewAllScheduledFlights();
	public ScheduledFlight viewScheduledFlight(BigInteger id) throws ScheduledFlightNotFoundException;
	

}
