package com.slide.project.demo.roles.admin;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/v1/admin")
public class AdminRestController {

    private final AdminDetailsServiceImpl adminDetailsService;

    public AdminRestController(AdminDetailsServiceImpl adminDetailsService) {
        this.adminDetailsService = adminDetailsService;
    }

    @PostMapping("/newAdmin")
    public Long createAdmin(@RequestBody Admin admin) {
        return adminDetailsService.create(admin);
    }

    @GetMapping("/admin")
    public Admin returnAdminByAdminId(@RequestParam Long id){
        return adminDetailsService.getAdminByAdminId(id).orElse(null);
    }
    @PostMapping("/newAdmin01")
    public Admin createAdmin01(@RequestBody Admin admin) {
        return adminDetailsService.create01(admin);
    }
}
