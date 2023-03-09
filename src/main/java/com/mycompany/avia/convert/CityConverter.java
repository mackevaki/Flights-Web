package com.mycompany.avia.convert;

import com.mycompany.avia.controllers.CitiesController;
import com.mycompany.avia.spr.objects.City;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@RequestScoped
public class CityConverter implements Converter, Serializable {
    @Inject
    private CitiesController citiesController;

    public CitiesController getCitiesController() {
        return citiesController;
    }

    public void setCitiesController(CitiesController citiesController) {
        this.citiesController = citiesController;
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s != null && !s.trim().isEmpty()) {
            try {
                return citiesController.getCity(Long.parseLong(s));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o != null) {
            return String.valueOf(((City) o).getId());
        }
        return null;
    }
}
