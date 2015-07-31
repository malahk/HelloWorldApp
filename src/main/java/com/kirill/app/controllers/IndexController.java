package com.kirill.app.controllers;

import com.kirill.app.dao.UserDAOImpl;
import com.kirill.app.models.Roles;
import com.kirill.app.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
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
            HttpServletResponse response,
            @CookieValue(value = "user_id", defaultValue = "") String user_id
    ) {
        if (user_id.equals("")) {
            return "redirect:/login";
        }

        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUser(Integer.valueOf(user_id));

        if (Roles.isAdmin(user.getRole())) {
            return "redirect:/user_list";
        }

        if (Roles.isUser(user.getRole())) {
            return "redirect:/helloPage";
        }

        return "index";
    }

    @RequestMapping(value = "/helloPage", method = RequestMethod.GET)
    public ModelAndView comeBackPage (@CookieValue(value = "user_id", defaultValue = "") String user_id) {
        User user = new UserDAOImpl().getUser(Integer.valueOf(user_id));
        System.out.println(user.toString());

        ModelAndView mav = new ModelAndView("helloPage");
        mav.addObject(user);
        return mav;
    }

    @RequestMapping(value = "/logOut", method = RequestMethod.GET)
    public String logOut (HttpServletResponse response) {
        response.addCookie(new Cookie("user_id", ""));

        return "redirect:/";
    }
}
