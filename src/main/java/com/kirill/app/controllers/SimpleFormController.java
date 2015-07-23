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
public class SimpleFormController {

    @RequestMapping(value = "createForm1", method = RequestMethod.GET)
    public ModelAndView simpleFormCreate() {

        return new ModelAndView("simpleForm");
    }

    @RequestMapping(value = "createForm1", method = RequestMethod.POST)
    public ModelAndView simpleFormCreate(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("dataFormView");
        mav.addObject("firstName", request.getParameter("firstName"));
        mav.addObject("lastName", request.getParameter("lastName"));

        return mav;
    }


}
