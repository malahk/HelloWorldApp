package com.kirill.app.controllers;

import com.kirill.app.dao.UserDAOImpl;
import com.kirill.app.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Admin on 25.06.2015.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout)
    {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("loginForm");

        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String startCreate(
            HttpServletRequest request
    ) {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getByLogin(request.getParameter("login"));

        if (user == null || ! user.getPassword().equals(request.getParameter("password"))) {
            return "redirect:/login";
        }

        return "redirect:/";
    }
}
