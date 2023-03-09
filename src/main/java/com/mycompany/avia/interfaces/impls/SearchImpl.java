package com.mycompany.avia.interfaces.impls;

import com.mycompany.avia.database.CityDB;
import com.mycompany.avia.database.FlightDB;
import com.mycompany.avia.interfaces.Search;
import com.mycompany.avia.objects.Flight;
import com.mycompany.avia.spr.objects.City;
import com.mycompany.avia.utils.GMTCalendar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchImpl implements Search {
    private FlightDB flightDB = FlightDB.getInstance();
    private CityDB cityDB = CityDB.getInstance();

    @Override
    public ArrayList<Flight> searchFlight(long date, City cityFrom, City cityTo) {
        
        ArrayList<Flight> list = new ArrayList<>();
        
        try {
            Calendar c = GMTCalendar.getInstance();
            c.setTimeInMillis(date);
            
            list.addAll(flightDB.executeList(flightDB.getStmt(c, cityFrom, cityTo)));
        } catch (SQLException ex) {
            Logger.getLogger(SearchImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }    

    @Override
    public ArrayList<City> getAllCities() {
        ArrayList<City> list = new ArrayList<>();
            try {
            
            list.addAll(cityDB.executeList(cityDB.getAllObjects()));
        } catch (SQLException ex) {
            Logger.getLogger(SearchImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
}
