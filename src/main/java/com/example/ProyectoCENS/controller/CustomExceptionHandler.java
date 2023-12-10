package com.example.ProyectoCENS.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error"); // Página de error personalizada
        modelAndView.addObject("error", ex.getMessage()); // Agregar detalles del error a la vista
        return modelAndView;
    }
}