package spring.demos.car_system.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import spring.demos.car_system.domain.binding_models.ModelCreateDto;
import spring.demos.car_system.domain.entities.Brand;
import spring.demos.car_system.services.interfaces.BrandService;
import spring.demos.car_system.services.interfaces.ModelService;

import java.util.List;

@Controller
@RequestMapping("/add-model")
public class ModelController {
    private final ModelService modelService;
    private final BrandService brandService;

    @Autowired
    public ModelController(ModelService modelService, BrandService brandService) {
        this.modelService = modelService;
        this.brandService = brandService;
    }

    @GetMapping
    public ModelAndView getModelForm(ModelAndView modelAndView, @ModelAttribute(name = "model") ModelCreateDto modelCreateDto){
        List<Brand> allBrands = this.brandService.getAllBrands();
        modelAndView.setViewName("model-add");
        modelAndView.addObject("brands", allBrands);
        return modelAndView;
    }

    @PostMapping
    public RedirectView postModelForm(@ModelAttribute(name = "model") ModelCreateDto modelCreateDto){
        this.modelService.createModel(modelCreateDto);
        return new RedirectView("/offers/all");
    }
}
