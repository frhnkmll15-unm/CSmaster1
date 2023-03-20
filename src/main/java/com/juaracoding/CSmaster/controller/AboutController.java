package com.juaracoding.CSmaster.controller;/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Moh. Ikhsan a.k.a. Fitriyani
Java Developer
Created on 3/19/2023 5:17 PM
@Last Modified 3/19/2023 5:17 PM
Version 1.0
*/


import com.juaracoding.CSmaster.configuration.OtherConfig;
import com.juaracoding.CSmaster.utils.MappingAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/about")

public class AboutController {


    private Map<String,Object> objectMapper = new HashMap<String,Object>();

    private String [] strExceptionArr = new String[2];

    private MappingAttribute mappingAttribute = new MappingAttribute();
    @GetMapping("/v1/lokasi/default")
    public String getDefaultData(Model model, WebRequest request)
    {
        if(OtherConfig.getFlagSessionValidation().equals("y"))
        {
            mappingAttribute.setAttribute(model,objectMapper,request);//untuk set session
            if(request.getAttribute("USR_ID",1)==null){
                return "redirect:/api/check/logout";
            }
        }

        return "/about/lokasi";
    }

    @GetMapping("/v1/contact/default")
    public String getDefaultContact(Model model, WebRequest request)
    {
        if(OtherConfig.getFlagSessionValidation().equals("y"))
        {
            mappingAttribute.setAttribute(model,objectMapper,request);//untuk set session
            if(request.getAttribute("USR_ID",1)==null){
                return "redirect:/api/check/logout";
            }
        }

        return "/about/contact";
    }

}
