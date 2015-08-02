package com.kirill.app.controllers;

import com.kirill.app.dao.UserDAO;
import com.kirill.app.dao.UserDAOImpl;
import com.kirill.app.models.Roles;
import com.kirill.app.models.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 28.07.2015
 */
@Controller
public class IndexController
{

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexShow(
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }

        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/user_list";
        }

        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MODERATOR"))) {
            return "redirect:/moderator_page";
        }

        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            return "redirect:/helloPage";
        }

        return "redirect:/login";
    }

    @RequestMapping(value = "/helloPage", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Login");
        model.addObject("message", "You have successfully logged in!");

        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("helloPage");

        return model;

    }

    @RequestMapping(value = "moderator_page", method = RequestMethod.GET)
    public ModelAndView moderatorLogInPage() {
        UserDAO userDAO = new UserDAOImpl();
        List<User> users = userDAO.getAll();
        ModelAndView mav = new ModelAndView("moderatorLogInPage");
        mav.addObject(users);

        return mav;
    }

//    @RequestMapping(value = "/logOut", method = RequestMethod.GET)
//    public String logOut () {
//
//        return "redirect:/";
//    }
}
