package com.example.Flight.controller;

import com.example.Flight.entity.Flight;
import com.example.Flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flights/f1")
public class FlightController {
    @Autowired
    FlightService flightService;

    @GetMapping("/flight")
    public ResponseEntity<List<Flight>> getAllFlightRecords(){

        List<Flight>flightList=flightService.getAllFlight();
        return new ResponseEntity<List<Flight>>(flightList,new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/flight/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable("id")Long id){
        Flight flight=flightService.getFlightById(id);
        return new ResponseEntity<Flight>(flight,new HttpHeaders(),HttpStatus.OK);
    }
    @PostMapping("/flight")
    public ResponseEntity<Flight>createFlight(@RequestBody Flight flight){
        Flight flight1=flightService.createOrUpdateFlight(flight);
        return new  ResponseEntity<Flight>(flight1,new HttpHeaders(),HttpStatus.OK);
    }
    @DeleteMapping("/flight/{id}")
    public void deletesFlightById(@PathVariable("id") Long id){
      flightService.deleteFlightById(id);
    }
}
