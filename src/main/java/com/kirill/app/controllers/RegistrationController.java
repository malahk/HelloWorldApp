package com.kirill.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 25.06.2015.
 */
@Controller
public class RegistrationController {

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView registrationShow() {

        return new ModelAndView("registrationForm");
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView registrationCreate(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("dataFormView");
        mav.addObject("firstName", request.getParameter("firstName"));
        mav.addObject("lastName", request.getParameter("lastName"));
        mav.addObject("age", request.getParameter("age"));
        mav.addObject("country", request.getParameter("country"));
        mav.addObject("street", request.getParameter("street"));
        mav.addObject("zipCode", request.getParameter("zipCode"));
        mav.addObject("musicType", request.getParameter("musicType"));
        mav.addObject("password", request.getParameter("password"));

        return mav;
    }
}
