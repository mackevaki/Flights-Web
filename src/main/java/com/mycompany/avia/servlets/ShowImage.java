package com.mycompany.avia.servlets;

import com.mycompany.avia.controllers.SearchFlightController;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "ShowImage", value = "/ShowImage")
public class ShowImage extends HttpServlet {
    @Inject
    private SearchFlightController searchFlightController;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");

        try (OutputStream out = response.getOutputStream()) {
            int index = Integer.parseInt(request.getParameter("index"));

            byte[] image = searchFlightController.getFlights().get(index).getAircraft().getCompany().getIcon();

            response.setContentLength(image.length);

            out.write(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
