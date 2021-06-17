package com.hcr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

//@Controller
//@SessionAttributes("type")
@RestController
public class ResponseControoler {
    //好
    @Autowired
    private HttpSession httpSession;

    @RequestMapping("response1")
    public String response1(){
        System.out.println();
        return "index";
    }

    @RequestMapping("/httpServletRequest")
    public String servlet(HttpServletRequest request){
        request.setAttribute("type","HttpServletRequest");
        return "main";
    }

    @RequestMapping("/model")
    public String map(Model model){
        model.addAttribute("type","model");
        return "main";
    }

    @RequestMapping("/modelMap")
    public String modelMap(ModelMap modelMap){
        modelMap.put("type","modelMap");
        return "main";
    }

    @RequestMapping("/map")
    public String map(Map map){
        map.put("type","map");
        return "main";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("type","modelAndView");
        return modelAndView;
    }

    @RequestMapping("/sevlet/session")
    public String sevletSession(HttpSession session){
        session.setAttribute("type","session");
        return "main";
    }

    @RequestMapping("/sevlet/autowiredsession")
    public String autowiredSession(){
        httpSession.setAttribute("type","autowiredsession");
        return "main";
    }

//    @RequestMapping("/sevlet/autowiredsession")
//    public String autowiredSession(@SessionAttribute(value = "type" ,required = false) String type){
//        System.out.append(type);
//        return "main";
//    }

    private HttpSession httpSession2;
    @ModelAttribute
    public void showModelAttribute(HttpSession session){
        this.httpSession2 = session;
    }

    @RequestMapping("/json")
    //@ResponseBody
    public String json(HttpSession session){
        Map map = new HashMap();
        map.put("name","hcr");
        map.put("age",30);
        System.out.println(map.toString());
        return map.toString();
    }
}
