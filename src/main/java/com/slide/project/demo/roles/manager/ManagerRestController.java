package com.slide.project.demo.roles.manager;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/v1/manager")
public class ManagerRestController  {
    private final ManagerDetailsServiceImpl managerDetailsService;

    public ManagerRestController(ManagerDetailsServiceImpl managerDetailsService) {
        this.managerDetailsService = managerDetailsService;
        }
    @RequestMapping("/newManager01")
    public Manager createManager01(@RequestBody Manager manager){
        return managerDetailsService.create01(manager);
    }

}
