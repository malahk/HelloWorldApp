package com.kirill.app.controllers;

import com.kirill.app.dao.MusicTypeDAO;
import com.kirill.app.dao.MusicTypeDAOImpl;
import com.kirill.app.models.MusicType;
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
public class MusicTypeController {

    @Autowired
    private MusicTypeDAO musicTypeDAO;

    @RequestMapping(value = "create_musictype", method = RequestMethod.GET)
    public ModelAndView musicTypePageShow() {

        return new ModelAndView("musictypeForm");
    }

    @RequestMapping(value = "create_musictype", method = RequestMethod.POST)
    public ModelAndView musicTypeCreate(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("dataFormView");
        mav.addObject("genre", request.getParameter("genre"));

        return mav;
    }

    @RequestMapping(value = "list_musictype", method = RequestMethod.GET)
    public ModelAndView listMusicTypes() {
        List<MusicType> musicTypes = this.musicTypeDAO.getAll();
        ModelAndView mav = new ModelAndView("musictypeFormList");
        mav.addObject(musicTypes);

        return mav;
    }

    @RequestMapping(value = "update_musictype", method = RequestMethod.GET)
    public ModelAndView updateMusicType(@RequestParam(value="id") Integer id) {
        ModelAndView mav = new ModelAndView("musictypeForm");
        mav.addObject(this.musicTypeDAO.getMusicType(id));

        return mav;
    }

    @RequestMapping(value = "update_musictype", method = RequestMethod.POST)
    public String updateMusicType(HttpServletRequest request) {
        MusicType musicType = new MusicType();
        String id = request.getParameter("id");
        String genre = request.getParameter("genre");
        musicType.setId(Integer.valueOf(id));
        musicType.setMusicGenre(genre);
        MusicTypeDAOImpl musicImpl = new MusicTypeDAOImpl();
        musicImpl.update(musicType);

        return "redirect:/list_musictype";
    }

    @RequestMapping(value = "delete_MusicType", method = RequestMethod.GET)
    public String deleteMusicType(HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        String id = request.getParameter("id");
        MusicTypeDAOImpl musicImpl = new MusicTypeDAOImpl();
        MusicType musicType = musicImpl.getMusicType(Integer.valueOf(id));
        musicImpl.delete(musicType);
        redirectAttributes.addFlashAttribute("message", String.format("%s successfully deleted!", musicType.getMusicGenre()));

        return "redirect:/list_musictype";
    }
}
