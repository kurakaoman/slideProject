package com.slide.project.demo.roles.admin;

import com.slide.project.demo.roles.customer.CustomerDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo-slide-project/admin")
public class AdminController {
    private AdminDetailsServiceImpl adminDetailsService;

    public AdminController(AdminDetailsServiceImpl adminDetailsService) {
        this.adminDetailsService = adminDetailsService;
    }

    @GetMapping("/id/{id}")
    //@Secured("Customer")
    public ModelAndView showIdCustomerPanel(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView();
        model.addObject("Admin", adminDetailsService.getAdminByAdminId(id));
        model.setViewName("/page/profilPage/customerPanel.html");
        return model;
    }
    @GetMapping("/{userName}")
    //@Secured("Customer")
    public ModelAndView showCustomerPanel(@PathVariable("userName") String name) {
        ModelAndView model = new ModelAndView();
        model.addObject("Customer", adminDetailsService.loadUserByUsername(name));
        model.setViewName("/page/profilPage/customerPanel.html");
        return model;
    }



}
