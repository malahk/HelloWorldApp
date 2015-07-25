package com.kirill.app.controllers;

import com.kirill.app.dao.RoleDAO;
import com.kirill.app.dao.RoleDAOImpl;
import com.kirill.app.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Admin on 22.07.2015.
 */
@Controller
public class RoleController {

    @Autowired
    private RoleDAO roleDAO;

    @RequestMapping(value = "create_role", method = RequestMethod.GET)
    public ModelAndView roleShow() {

        return new ModelAndView("roleCreateForm");
    }

    @RequestMapping(value = "create_role", method = RequestMethod.POST)
    public String roleCreate(HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        RoleDAOImpl roleImpl = new RoleDAOImpl();
        Role role = new Role();
        String roleName = request.getParameter("roleName");
        role.setRoleName(roleName);
        roleImpl.create(role);
        redirectAttributes.addFlashAttribute("message", String.format("New role %s successfully created!", role.getRoleName()));

        return "redirect:/role_list";
    }

    @RequestMapping(value = "role_list", method = RequestMethod.GET)
    public ModelAndView rolesList() {
        List<Role> roles = this.roleDAO.getAll();
        ModelAndView mav = new ModelAndView("roleFormList");
        mav.addObject(roles);

        return mav;
    }

    @RequestMapping(value = "update_role", method = RequestMethod.GET)
    public ModelAndView updateRole (@RequestParam(value="id") Integer id) {
        ModelAndView mav = new ModelAndView("roleUpdateForm");
        mav.addObject(this.roleDAO.getRole(id));

        return mav;
    }

    @RequestMapping(value = "update_role", method = RequestMethod.POST)
    public String updateRole (HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        Role role = new Role();
        String id = request.getParameter("id");
        String roleName = request.getParameter("roleName");
        role.setId(Integer.valueOf(id));
        role.setRoleName(roleName);
        RoleDAOImpl roleImpl = new RoleDAOImpl();
        roleImpl.update(role);
        redirectAttributes.addFlashAttribute("message", "Role is successfully updated!");

        return "redirect:/role_list";
    }

    @RequestMapping(value = "delete_role", method = RequestMethod.GET)
    public String deleteMusicType(HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        String id = request.getParameter("id");
        RoleDAOImpl roleImpl = new RoleDAOImpl();
        Role role = roleImpl.getRole(Integer.valueOf(id));
        roleImpl.delete(role);
        redirectAttributes.addFlashAttribute("message", String.format("Role %s successfully deleted!", role.getRoleName()));

        return "redirect:/role_list";
    }

}
