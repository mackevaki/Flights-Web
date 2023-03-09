package com.mycompany.avia.controllers;

import com.mycompany.avia.interfaces.impls.SearchImpl;
import com.mycompany.avia.objects.Flight;
import com.mycompany.avia.spr.objects.City;
import com.mycompany.avia.utils.GMTCalendar;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Named
@SessionScoped
public class SearchFlightController implements Serializable {
    private Date dateDepart = new Date(); // current date
    private Date dateReturn = new Date(dateDepart.getTime() + 604800000); // current date + 7 days

    private City cityTo;
    private City cityFrom;

    private int passengersCount = 1;

    private SearchImpl searchImpl = new SearchImpl();

    private TimeZone timeZone = GMTCalendar.getInstance().getTimeZone();

    public void search(ActionEvent event) {
        List<Flight> flights = searchImpl.searchFlight(dateDepart.getTime(), cityFrom, cityTo);
        System.out.println("flights = " + flights);
    }

    public void updatePassengersCount() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        passengersCount = Integer.parseInt(params.get("count"));
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public City getCityTo() {
        return cityTo;
    }

    public void setCityTo(City cityTo) {
        this.cityTo = cityTo;
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(City cityFrom) {
        this.cityFrom = cityFrom;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(int passengersCount) {
        this.passengersCount = passengersCount;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}
