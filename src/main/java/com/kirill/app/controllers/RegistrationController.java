package com.kirill.app.controllers;

import com.kirill.app.dao.*;
import com.kirill.app.models.Address;
import com.kirill.app.models.Roles.RoleEnum;
import com.kirill.app.models.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Admin on 25.06.2015.
 */
@Controller
public class RegistrationController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registrationShow() {

        return new ModelAndView("registrationForm");
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String  registrationCreate(HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        User user = extractUser(request);
        extractAddress(request, user);
        if(!(request.getParameter("password").equals(request.getParameter("repeatedPassword")))) {
            redirectAttributes.addFlashAttribute("password_error", "Passwords didn't match, please repeat once more!");

            return "redirect:/register";
        }
        UserDAOImpl userDAO = new UserDAOImpl();
        try {
            userDAO.create(user);
        } catch (SQLException e) {
            redirectAttributes.addFlashAttribute("login_error", String.format("This login (%s) is already exist, please choose another one!", request.getParameter("login")));

            return "redirect:/register";
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }

        model.setViewName("403");
        return model;
    }

    private User extractUser(HttpServletRequest request) {
        User user = new User();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(pass);
        user.setAge(Integer.valueOf(age));
        RoleDAOImpl roleDAO = new RoleDAOImpl();
        user.setRole(roleDAO.getByName(RoleEnum.DEFAULT));

        return user;
    }

    private void extractAddress(HttpServletRequest request, User user){
        String country = request.getParameter("country");
        if (country.equals("")) {
            return;
        }

        Address address = new Address();
        String street = request.getParameter("street");
        String zipCode = request.getParameter("zipCode");
        address.setCountry(country);
        address.setStreet(street);
        address.setZipCode(Integer.valueOf(zipCode));
        user.setAddress(address);
    }

}

