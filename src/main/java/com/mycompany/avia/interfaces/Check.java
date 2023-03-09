package com.mycompany.avia.interfaces;

import com.mycompany.avia.objects.Reservation;

public interface Check {
    Reservation checkReservationByCode(String code);

//    Reservation checkReservationByDateReserv(String docNumber);
//
//    Reservation checkReservationByDateReserv(long date);
//
//    Reservation checkReservationByFamilyName(String familyName);

}
