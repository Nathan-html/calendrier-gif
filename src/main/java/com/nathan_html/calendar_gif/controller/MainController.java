package com.nathan_html.calendar_git.controller;

import com.nathan_html.calendar_git.model.Day;
import com.nathan_html.calendar_git.model.Gif.GifRemote;
import com.nathan_html.calendar_git.model.User.User;
import com.nathan_html.calendar_git.service.DayService;
import com.nathan_html.calendar_git.service.EmotionService;
import com.nathan_html.calendar_git.service.ThemeService;
import com.nathan_html.calendar_git.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class MainController {

    private final DayService dayService;
    private final EmotionService emotionService;
    private final UserService userService;
    private final ThemeService themeService;
    private final String title = "calendrier gif";
    private final HttpSession session;
    private static final int daysByPage = 7;

    public MainController(
            EmotionService emotionService,
            UserService userService,
            ThemeService themeService,
            DayService dayService,
            HttpSession session
    ) {
        super();
        this.dayService = dayService;
        this.emotionService = emotionService;
        this.userService = userService;
        this.themeService = themeService;
        this.session = session;
    }

    @RequestMapping({"/", "/home"})
    public ModelAndView home () {
//            ModelAndView mav = new ModelAndView("calendar/calendar");
//            mav.addObject("title", title);
//            return mav;
            ModelAndView mav = new ModelAndView("auth/login");
            mav.addObject("title", title);
            return mav;
    }

    @PostMapping("login")
    public ModelAndView loginPost (
        @RequestParam(name = "email") String email,
        @RequestParam(name = "password") String password
    ) {
        if (userService.login(email, password)==null) {
            return new ModelAndView("redirect:");
        } else {
            User currentUser = userService.login(email, password);
            session.setAttribute("currentUser", currentUser);
            return new ModelAndView("redirect:calendar");
        }
    }

    @RequestMapping("/register")
    public ModelAndView register (@ModelAttribute User user) {
        ModelAndView mav = new ModelAndView("auth/register");
        mav.addObject("themes", themeService.getThemes());
        mav.addObject("title", title);
        return mav;
    }

    @PostMapping("register")
    public ModelAndView registerPost (@Valid @ModelAttribute User newUser, BindingResult result) {
        if (result.hasErrors()) {
            return register(newUser);
        }
        userService.addUser(newUser);
        session.setAttribute("currentUser", newUser);
        return new ModelAndView("redirect:");
    }

    @RequestMapping("/logout")
    public ModelAndView logout () {
        session.invalidate();
        return new ModelAndView("redirect:");
    }

    @RequestMapping("/emotion")
    public ModelAndView emotion () {
        ModelAndView mav = new ModelAndView("emotion/list-emotions");
        mav.addObject("emotions", emotionService.getEmotions());
        mav.addObject("title", title);
        return mav;
    }

    @RequestMapping("/emotion/create")
    public ModelAndView emotionCreate () {
        ModelAndView mav = new ModelAndView("emotion/add-emotion");
        mav.addObject("title", title);
        return mav;
    }

    @PostMapping("/emotion/create")
    public ModelAndView emotionCreatePost(
        @RequestParam("code") String code,
        @RequestParam("name") String name
    ) {
        emotionService.addEmotion(code, name);
        return new ModelAndView("redirect:");
    }

    @RequestMapping("/calendar")
    public ModelAndView calendar (@PageableDefault(size = daysByPage, sort = "date") Pageable pageable) {
        ModelAndView mav = new ModelAndView("calendar/calendar");
        mav.addObject("title", title);
        mav.addObject("days", dayService.getDays(pageable));
        return mav;
    }

    @RequestMapping("calendar/add-remote-gif")
    public ModelAndView addRemoteGif (
            @RequestParam("day") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dayId,
            @ModelAttribute GifRemote gifRemote
    ) {
        ModelAndView mav = new ModelAndView("calendar/addRemoteGif");
//        Day day = dayService.getDays(dayId);
//        gifDistant.setJour(jour);
        mav.addObject("title", title);
        return mav;
    }

    @PostMapping("create-remote-gif")
    public ModelAndView addRemoteGifPost(
            @RequestParam("day") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate day
    ) {
        return new ModelAndView("redirect:calendar");
    }

    @RequestMapping("calendar/add-local-gif")
    public ModelAndView addRLocalGif () {
        ModelAndView mav = new ModelAndView("calendar/addLocalGif");
        mav.addObject("title", title);
        return mav;
    }
}
