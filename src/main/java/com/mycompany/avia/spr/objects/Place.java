package com.mycompany.avia.spr.objects;

import com.mycompany.avia.annotations.ExceptionMessage;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@ExceptionMessage(message="Объект place должен быть заполнен")
public class Place {
    private long id;
    
    @XmlElement(required = true)
    @ExceptionMessage(message = "Не указан ряд места")
    private String seatLetter;

    @XmlElement(required = true)
    @ExceptionMessage(message = "Не указан номер места")
    private int seatNumber;    
    
    @XmlElement(required = true)
    @ExceptionMessage(message = "Не указан класс полета")
    private FlightClass flightClass;
    private boolean busy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    public String getSeatLetter() {
        return seatLetter;
    }

    public void setSeatLetter(String seatLetter) {
        this.seatLetter = seatLetter;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}
