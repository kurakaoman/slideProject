package com.slide.project.demo.tests;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/unauth/demo/slide/project/test01")
public class TestController {
    public TestController(){

    }

    @GetMapping("/inputTest01")
    public ModelAndView showInputTest(){

        ModelAndView model = new ModelAndView();
        model.setViewName("/page/inputTest/inputTest.html");
        return model;
    }

    @PostMapping(value = "/outputTest01")
    public ModelAndView showOutputTest(@RequestParam String username, @RequestParam String password){
        ModelAndView model = new ModelAndView();
        model.addObject("userName00", username);
        model.addObject("password00",password);
        model.setViewName("page/outputTest/outputTest");
        return model;
    }
}
