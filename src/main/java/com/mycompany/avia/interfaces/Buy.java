package com.mycompany.avia.interfaces;

import com.mycompany.avia.objects.Flight;
import com.mycompany.avia.objects.Passenger;
import com.mycompany.avia.spr.objects.Place;

public interface Buy {
    boolean buyTicket(Flight flight, Place place, Passenger passenger, String addInfo);

}
