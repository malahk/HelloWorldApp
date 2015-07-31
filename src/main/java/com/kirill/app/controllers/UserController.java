package com.kirill.app.controllers;

import com.kirill.app.dao.UserDAO;
import com.kirill.app.dao.UserDAOImpl;
import com.kirill.app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Kirill
 *
 * @author Kirill Malah
 * @since date
 */

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "create_user", method = RequestMethod.GET)
    public ModelAndView userShow() {

        return new ModelAndView("userCreateForm");
    }

    @RequestMapping(value = "create_user", method = RequestMethod.POST)
    public ModelAndView userCreate(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("dataFormView");
        mav.addObject("firstName", request.getParameter("firstName"));
        mav.addObject("lastName", request.getParameter("lastName"));
        mav.addObject("age", request.getParameter("age"));
        mav.addObject("musicType", request.getParameter("musicType"));
        mav.addObject("role", request.getParameter("role"));
        mav.addObject("login", request.getParameter("login"));
        mav.addObject("password", request.getParameter("password"));
//        UserDAO userImpl = new UserDAOImpl();
//        User user = extractUserFromRequest(request);
//        userImpl.create(user);
//        mav.addObject(extractUserFromRequest(request));

        return mav;
    }

    @RequestMapping(value = "user_list", method = RequestMethod.GET)
    public ModelAndView userList(@CookieValue(value = "user_id", defaultValue = "") String user_id) {
        List<User> users = this.userDAO.getAll();
        ModelAndView mav = new ModelAndView("userFormList");
        mav.addObject(users);
        mav.addObject(this.userDAO.getUser(Integer.valueOf(user_id)));

        return mav;
    }

    @RequestMapping(value = "update_user", method = RequestMethod.GET)
    public ModelAndView updateUser(@RequestParam(value="id") Integer id) {
        ModelAndView mav = new ModelAndView("userUpdateForm");
        mav.addObject(this.userDAO.getUser(id));

        return mav;
    }

    @RequestMapping(value = "update_user", method = RequestMethod.POST)
    public ModelAndView updateUser(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("userUpdateForm");
        UserDAO userImpl = new UserDAOImpl();
        User user = extractUserFromRequest(request);
        userImpl.update(user);
        mav.addObject(userImpl);

        return mav;
    }

    @RequestMapping(value = "delete_user", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        String userId = request.getParameter("id");
        UserDAO userImpl = new UserDAOImpl();
        String name = userImpl.getUser(Integer.valueOf(userId)).getFirstName();
        String lastName = userImpl.getUser(Integer.valueOf(userId)).getLastName();
        userImpl.delete(userImpl.getUser(Integer.valueOf(userId)));
        redirectAttributes.addFlashAttribute("message", String.format("User %s %s successfully deleted!", lastName, name));

        return "redirect:/user_list";
    }

    private User extractUserFromRequest(HttpServletRequest request){
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        User user = new User();
        user.setAge(Integer.valueOf(age));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(pass);

        return user;
    }
}
