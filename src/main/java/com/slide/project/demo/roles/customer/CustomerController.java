package com.slide.project.demo.roles.customer;

        import com.slide.project.demo.roles.admin.Admin;
        import org.springframework.security.access.annotation.Secured;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo/slide/project/customer")
public class CustomerController {
    private CustomerDetailsServiceImpl customerDetailsService;

    public CustomerController(CustomerDetailsServiceImpl customerDetailsService) {
        this.customerDetailsService = customerDetailsService;
    }

    @GetMapping("/id/{id}")
    //@Secured("Customer")
    public ModelAndView showIdCustomerPanel(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView();
        model.addObject("Customer", customerDetailsService.getCustomerByCustomerId(id));
        model.setViewName("/page/profilPage/customerPanel.html");
        return model;
    }
    @GetMapping("/{userName}")
    //@Secured("Customer")
    public ModelAndView showCustomerPanel(@PathVariable("userName") String name) {
        ModelAndView model = new ModelAndView();
        model.addObject("Customer", customerDetailsService.loadUserByUsername(name));
        model.setViewName("/page/profilPage/customerPanel.html");
        return model;
    }




}
