package com.kirill.app.controllers;

import com.kirill.app.dao.UserDAO;
import com.kirill.app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/some_shit", method = RequestMethod.GET)
    public ModelAndView homePage() {


        User user = new User();
        user.setFirstName("Kirill");
        user.setLastName("Malah");
        user.setLogin("Invis147");
        user.setPassword("qwerty");
        user.setAge(27);

        this.userDAO.create(user);


        return new ModelAndView("index");
    }
}
