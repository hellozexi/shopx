package com.mikey.shopx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {
    @RequestMapping("/index")
    public String sayIndex() {
        return "index";
    }
    @RequestMapping("/about")
    public String sayAbout() {
        return "about";
    }
}
