package com.kirill.app.controllers;

import com.kirill.app.dao.AddressDAO;
import com.kirill.app.dao.AddressDAOImpl;
import com.kirill.app.dao.UserDAOImpl;
import com.kirill.app.models.Address;
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
public class AddressController {

    @Autowired
    private AddressDAO addressDAO;

    @RequestMapping(value = "create_address", method = RequestMethod.GET)
    public ModelAndView addressShow(HttpServletRequest request) throws Exception{
        ModelAndView mav = new ModelAndView("addressCreateForm");
//        if (request.getParameter("userId") == null) {
//            throw new Exception("Item not found!");
//        }
        mav.addObject("userId", request.getParameter("userId"));

        return mav;
    }

    @RequestMapping(value = "create_address", method = RequestMethod.POST)
    public String createAddress(@RequestParam(value="userId") Integer userId, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        AddressDAOImpl addressImpl = new AddressDAOImpl();
        Address address = new Address();
        UserDAOImpl userImpl = new UserDAOImpl();
        String country = request.getParameter("country");
        String street = request.getParameter("street");
        String zipCode = request.getParameter("zipCode");
        address.setCountry(country);
        address.setStreet(street);
        address.setZipCode(Integer.valueOf(zipCode));
        address.setUser(userImpl.getUser(userId));
        addressImpl.create(address);
        redirectAttributes.addFlashAttribute("message", "Address successfully created!");

        return "redirect:/address_list";

    }

    @RequestMapping(value = "address_list", method = RequestMethod.GET)
    public ModelAndView addressList() {
        List<Address> addresses = this.addressDAO.getAll();
        ModelAndView mav = new ModelAndView("addressFormList");
        mav.addObject(addresses);

        return mav;
    }

    @RequestMapping(value = "update_address", method = RequestMethod.GET)
    public ModelAndView updateAddress(@RequestParam(value="id") Integer id) {
        ModelAndView mav = new ModelAndView("addressUpdateForm");
        mav.addObject(this.addressDAO.getAddress(id));

        return mav;
    }

    @RequestMapping(value = "update_address", method = RequestMethod.POST)
    public String  updateAddress(HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        Address address = new Address();
        String id = request.getParameter("id");
        String country = request.getParameter("country");
        String street = request.getParameter("street");
        String zipCode = request.getParameter("zipCode");
        address.setId(Integer.valueOf(id));
        address.setCountry(country);
        address.setStreet(street);
        address.setZipCode(Integer.valueOf(zipCode));
        AddressDAOImpl addressImpl = new AddressDAOImpl();
        addressImpl.update(address);
        redirectAttributes.addFlashAttribute("message", "Address successfully updated!");

        return "redirect:/address_list";
    }

    @RequestMapping(value = "delete_address", method = RequestMethod.GET)
    public String deleteAddress(HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        String id = request.getParameter("id");
        AddressDAOImpl addressImpl = new AddressDAOImpl();
        Address address = addressImpl.getAddress(Integer.valueOf(id));
        addressImpl.delete(address);
        redirectAttributes.addFlashAttribute("message", "Address successfully deleted!");

        return "redirect:/address_list";
    }

}
