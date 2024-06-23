package com.example.controller;

import com.example.model.User;
import com.example.service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registro")
public class RegistrationController extends HttpServlet {
    private RegistrationService registrationService = new RegistrationService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String pais = request.getParameter("pais");

        User user = new User(nombre, pais);

        try {
            registrationService.registerUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("listado");
    }
}
