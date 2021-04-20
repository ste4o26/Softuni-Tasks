package spring.demos.car_system.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import spring.demos.car_system.domain.binding_models.BrandCreateDto;
import spring.demos.car_system.services.interfaces.BrandService;

@Controller
@RequestMapping("/add-brand")
public class BrandController {
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ModelAndView getBrandForm(@ModelAttribute(name = "brand") BrandCreateDto brandCreateDto, ModelAndView modelAndView){
        modelAndView.setViewName("brand-add");
        return modelAndView;
    }

    @PostMapping
    public RedirectView postBrandForm(@ModelAttribute(name = "brand")BrandCreateDto brandCreateDto) {
        this.brandService.createBrand(brandCreateDto);
        return new RedirectView("/offers/all");
    }
}
