package com.example.Flight.service;

import com.example.Flight.entity.Flight;

import java.util.List;

public interface FlightService {

    public List<Flight> getAllFlight();
    public Flight getFlightById(Long id);
    public Flight createOrUpdateFlight(Flight entity);
    public void deleteFlightById(Long id);
}
