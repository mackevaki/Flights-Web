package com.mycompany.avia.interfaces.sei;

import com.mycompany.avia.exceptions.ArgumentException;
import com.mycompany.avia.objects.Flight;
import com.mycompany.avia.objects.Passenger;
import com.mycompany.avia.objects.Reservation;
import com.mycompany.avia.spr.objects.City;
import com.mycompany.avia.spr.objects.Place;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.Use;

import java.util.ArrayList;

@WebService(name = "FlightWS", targetNamespace = "http://ws.flights.mycompany.com/")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public interface FlightSEI {
    Reservation checkReservationByCode(@WebParam(name = "code") String code) throws ArgumentException;

    ArrayList<City> getAllCities();

    ArrayList<Flight> searchFlight(@WebParam(name = "date") Long date, @WebParam(name = "cityFrom") City cityFrom, @WebParam(name = "cityTo") City cityTo) throws ArgumentException;
   
    boolean buyTicket(@WebParam(name = "flight") Flight flight, @WebParam(name = "place") Place place, @WebParam(name = "passenger") Passenger passenger, @WebParam(name = "addInfo") String addInfo) throws ArgumentException;
}
