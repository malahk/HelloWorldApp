package com.kirill.app.controllers;

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
//            HttpServletResponse response,
//            HttpServletRequest request,
//            @CookieValue(value = "user_id", defaultValue = "") String user_id
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof AnonymousAuthenticationToken) {
            return "redirect:/403";
        }

        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/user_list";
        }

        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            return "redirect:/helloPage";
        }

        return "redirect:/login";
    }

//    @RequestMapping(value = "/helloPage", method = RequestMethod.GET)
//    public ModelAndView comeBackPage (@CookieValue(value = "user_id", defaultValue = "") String user_id) {
//        User user = new UserDAOImpl().getUser(Integer.valueOf(user_id));
//        System.out.println(user.toString());
//
//        ModelAndView mav = new ModelAndView("helloPage");
//        mav.addObject(user);
//
//        return mav;
//    }

    @RequestMapping(value = "/helloPage", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("helloPage");

        return model;

    }

//    @RequestMapping(value = "/logOut", method = RequestMethod.GET)
//    public String logOut (HttpServletResponse response) {
//        response.addCookie(new Cookie("user_id", ""));
//
//        return "redirect:/";
//    }
}
