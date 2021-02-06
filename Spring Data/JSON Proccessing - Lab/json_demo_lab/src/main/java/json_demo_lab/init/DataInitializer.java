package json_demo_lab.init;

import json_demo_lab.domain.dtos.PostCreateDto;
import json_demo_lab.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
//    private final List<PostCreateDto> posts = List.of(
//            new PostCreateDto("Welcome to Spring Data",
//                    "Developing data access object with Spring Data is easy ...",
//                    "https://www.publicdomainpictures.net/pictures/320000/velka/rosa-klee-blute-blume.jpg",
//                    "Trayan Iliev",
//                    LocalDate.parse("2020-11-20")),
//
//            new PostCreateDto("Reactive Spring Data",
//                    "Check R2DBC for reactive JDBC API ...",
//                    "https://www.publicdomainpictures.net/pictures/70000/velka/spring-grass-in-sun-light.jpg",
//                    "Trayan Iliev",
//                    LocalDate.parse("2020-11-20")),
//
//            new PostCreateDto("New in Spring 5",
//                    "Webflux provides reactive and non-blocking web service implementation ...",
//                    "https://www.publicdomainpictures.net/pictures/320000/velka/blute-blumen-garten-bluhen-1577191608UTW.jpg",
//                    "Doncho Minkov",
//                    LocalDate.parse("2019-10-18")),
//
//            new PostCreateDto("Beginnig REST with Spring 5",
//                    "Spring MVC and WebFlux make implementing REST full services really easy ...",
//                    "https://www.publicdomainpictures.net/pictures/20000/velka/baby-lamb.jpg",
//                    "Trayan Iliev",
//                    LocalDate.parse("2020-11-20")));

    private final PostService postService;

    @Autowired
    public DataInitializer(PostService postService) {
        this.postService = postService;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.posts.forEach(this.postService::addPost);
    }
}
