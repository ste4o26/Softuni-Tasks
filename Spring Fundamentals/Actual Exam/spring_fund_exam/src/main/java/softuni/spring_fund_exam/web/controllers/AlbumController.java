package softuni.spring_fund_exam.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.spring_fund_exam.model.binding.AlbumAddBindingModel;
import softuni.spring_fund_exam.model.service.AlbumServiceModel;
import softuni.spring_fund_exam.services.interfaces.AlbumService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    @Autowired
    public AlbumController(AlbumService albumService, ModelMapper modelMapper, HttpSession httpSession) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (this.httpSession.getAttribute("username") == null){
            return "redirect:/";
        }

        if (!model.containsAttribute("albumAddBindingModel")) {
            model.addAttribute("albumAddBindingModel", new AlbumAddBindingModel());
        }

        return "add-album";
    }

    @PostMapping("/add")
    public String postAdd(@Valid @ModelAttribute("albumAddBindingModel")
                                  AlbumAddBindingModel albumAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel", bindingResult);
            return "redirect:/albums/add";
        }

        AlbumServiceModel albumServiceModel = this.modelMapper.map(albumAddBindingModel, AlbumServiceModel.class);
        this.albumService.persist(albumServiceModel, this.httpSession);

        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        if (this.httpSession.getAttribute("username") == null){
            return "redirect:/";
        }

        this.albumService.deleteById(id);
        return "redirect:/home";
    }
}
