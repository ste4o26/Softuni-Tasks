package softuni.spring_fund_exam.services.interfaces;

import softuni.spring_fund_exam.model.service.AlbumServiceModel;
import softuni.spring_fund_exam.model.view.AlbumViewModel;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface AlbumService {
    AlbumServiceModel persist(AlbumServiceModel albumServiceModel, HttpSession httpSession);

    List<AlbumViewModel> fetchAll();

    Integer fetchTotalCopies();

    AlbumServiceModel deleteById(String id);
}
