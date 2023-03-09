package com.mycompany.avia.interfaces;

import com.mycompany.avia.objects.Flight;
import com.mycompany.avia.spr.objects.City;

import java.util.ArrayList;

public interface Search {
    ArrayList<Flight> searchFlight(long date, City cityFrom, City cityTo);
    
    ArrayList<City> getAllCities();
}
