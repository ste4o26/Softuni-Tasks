package spring.demos.car_system.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class AuthController {

    @GetMapping("/register")
    public ModelAndView getRegisterForm(ModelAndView modelAndView){
        modelAndView.setViewName("register");
        return modelAndView;
    }
}
