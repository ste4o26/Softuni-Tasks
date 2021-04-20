package softuni.spring_fund_exam.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.spring_fund_exam.model.view.AlbumViewModel;
import softuni.spring_fund_exam.services.interfaces.AlbumService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private final AlbumService albumService;
    private final HttpSession httpSession;

    @Autowired
    public HomeController(AlbumService albumService, HttpSession httpSession) {
        this.albumService = albumService;
        this.httpSession = httpSession;
    }

    @GetMapping
    public String index() {
        if (this.httpSession.getAttribute("username") != null) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (this.httpSession.getAttribute("username") == null){
            return "redirect:/";
        }

        List<AlbumViewModel> allAlbums = this.albumService.fetchAll();
        Integer totalCopies = this.albumService.fetchTotalCopies();

        model.addAttribute("allAlbums", allAlbums);
        model.addAttribute("totalCopies", totalCopies);
        return "home";
    }
}
