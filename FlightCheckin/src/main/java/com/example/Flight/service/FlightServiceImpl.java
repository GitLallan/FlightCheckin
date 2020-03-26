package com.example.Flight.service;

import com.example.Flight.entity.Flight;
import com.example.Flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl  implements  FlightService{

    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<Flight> getAllFlight() {
        List<Flight> flightList=flightRepository.findAll();
        if(flightList.size()>0){
            return flightList;
        }
        return new ArrayList<Flight>();
    }

    @Override
    public Flight getFlightById(Long id) {
        Optional<Flight> flight=flightRepository.findById(id);
        if(flight.isPresent()){
            return flight.get();
        }
        return null;
    }

    @Override
    public Flight createOrUpdateFlight(Flight entity) {
        Optional<Flight>optionalFlight=flightRepository.findById(entity.getId());
        if (optionalFlight.isPresent()){
            Flight newflight=optionalFlight.get();
            newflight.setFlightNumber(entity.getFlightNumber());
            newflight.setArrivalCity(entity.getArrivalCity());
            newflight.setDepartureCity(entity.getDepartureCity());
            newflight.setOperatingAirlines(entity.getOperatingAirlines());

            newflight=flightRepository.save(newflight);
            return newflight;
        }else
            entity=flightRepository.save(entity);
        return entity;
    }

    @Override
    public void deleteFlightById(Long id) {

        Optional<Flight> flightOptional=flightRepository.findById(id);
        if(flightOptional.isPresent()){
            flightRepository.deleteById(id);
        }

    }
}
