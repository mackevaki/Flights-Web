package com.mycompany.avia.controllers;

import com.mycompany.avia.interfaces.impls.SearchImpl;
import com.mycompany.avia.spr.objects.City;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.omnifaces.cdi.Eager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
@Eager
public class CitiesController {
    private ArrayList<City> cities;

//    @Inject
    private SearchImpl searchImpl = new SearchImpl();

    public CitiesController() {
        cities = searchImpl.getAllCities();
        System.out.println("cities = " + cities);
    }

    public List<City> completeCities(String cityName) {
        List<City> newCities = cities.stream().filter(p -> p.getName().toLowerCase().startsWith(cityName.toLowerCase())).collect(Collectors.toList());
        return newCities;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public City getCity(long id) {
        Optional<City> city = cities.stream().filter(p -> p.getId() == id).findFirst();
        return city.get();
    }
}
