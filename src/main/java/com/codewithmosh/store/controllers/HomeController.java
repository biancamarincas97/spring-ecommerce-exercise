package com.codewithmosh.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    // server side rendering

    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute( "name",  "Bibu");

        return "index";
    }



}
