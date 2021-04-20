package softuni.spring_fund_exam.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.spring_fund_exam.model.binding.UserLoginBindingModel;
import softuni.spring_fund_exam.model.binding.UserRegisterBindingModel;
import softuni.spring_fund_exam.model.service.UserServiceModel;
import softuni.spring_fund_exam.services.interfaces.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Controller
@RequestMapping("/users")
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final HttpSession httpSession;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService, HttpSession httpSession) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.httpSession = httpSession;
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (this.httpSession.getAttribute("username") != null){
            return "redirect:/home";
        }

        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }

        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute("userRegisterBindingModel")
                                       UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:/users/register";
        }

        String username = userRegisterBindingModel.getUsername();
        UserServiceModel isExisting = this.userService.fetchByUserName(username);
        if (isExisting != null && username.equals(isExisting.getUsername())){
            return "redirect:/users/register";
        }

        UserServiceModel userServiceModel = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);
        this.userService.persist(userServiceModel);

        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (this.httpSession.getAttribute("username") != null){
            return "redirect:/home";
        }

        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
        }

        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@Valid @ModelAttribute("userLoginBindingModel")
                                    UserLoginBindingModel userLoginBindingModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:/users/login";
        }

        UserServiceModel userServiceModel = this.userService.fetchByUserName(userLoginBindingModel.getUsername());
        if (userServiceModel == null || !userLoginBindingModel.getPassword().equals(userServiceModel.getPassword())) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:/users/login";
        }

        this.httpSession.setAttribute("username", userLoginBindingModel.getUsername());
        this.httpSession.setMaxInactiveInterval(1800);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        if (this.httpSession.getAttribute("username") == null){
            return "redirect:/";
        }

        httpSession.invalidate();
        return "redirect:/";
    }
}
