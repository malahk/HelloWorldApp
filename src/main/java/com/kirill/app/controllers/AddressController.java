package com.kirill.app.controllers;

import com.kirill.app.dao.AddressDAO;
import com.kirill.app.dao.AddressDAOImpl;
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
    public ModelAndView addressShow() {

        return new ModelAndView("addressForm");
    }

    @RequestMapping(value = "create_address", method = RequestMethod.POST)
    public ModelAndView createAddress(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("dataFormView");
        mav.addObject("country", request.getParameter("country"));
        mav.addObject("street", request.getParameter("street"));
        mav.addObject("zipCode", request.getParameter("zipCode"));

        return mav;
    }

    @RequestMapping(value = "address_list", method = RequestMethod.GET)
    public ModelAndView rolesList() {
        List<Address> addresses = this.addressDAO.getAll();
        ModelAndView mav = new ModelAndView("addressFormList");
        mav.addObject(addresses);

        return mav;
    }

    @RequestMapping(value = "update_address", method = RequestMethod.GET)
    public ModelAndView updateAddress(@RequestParam(value="id") Integer id) {
        ModelAndView mav = new ModelAndView("addressForm");
        mav.addObject(this.addressDAO.getAddress(id));

        return mav;
    }

    @RequestMapping(value = "update_address", method = RequestMethod.POST)
    public String  updateAddress(HttpServletRequest request) {
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

        return "redirect:/address_list";
    }

    @RequestMapping(value = "delete_address", method = RequestMethod.POST)
    public String deleteAddress(HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        String id = request.getParameter("id");
        AddressDAOImpl addressImpl = new AddressDAOImpl();
        Address address = addressImpl.getAddress(Integer.valueOf(id));
        addressImpl.delete(address);
        redirectAttributes.addFlashAttribute("message", "Address successfully deleted!");

        return "redirect:/address_list";
    }

}
