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
public class StartPageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView startShow() {

        return new ModelAndView("startpageForm");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView startCreate(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("dataFormView");
        mav.addObject("login", request.getParameter("login"));
        mav.addObject("password", request.getParameter("password"));

        return mav;
    }
}
