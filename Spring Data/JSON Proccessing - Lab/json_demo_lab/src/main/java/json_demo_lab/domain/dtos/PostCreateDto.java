package json_demo_lab.domain.dtos;

import com.google.gson.annotations.Expose;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateDto {
    @Expose
    @NonNull
    @NotNull
    private Long id;

    @Expose
    @NonNull
    @NotNull(message = "Title can not be null!")
    @Size(min = 5, max = 80, message = "Title should be at least 5 and at most 80 symbols long!")
    private String title;

    @Expose
    @NonNull
    @NotNull(message = "Content can not be null!")
    @Size(min = 20, max = 1000, message = "Content should be at least 20 and at most 1000 symbols long!")
    private String content;

    @Expose
    @NonNull
    @NotNull(message = "Image Url can not be null!")
    private String imageUrl;

    @Expose
    @NonNull
    @NotNull(message = "Author can not be null!")
    @Size(min = 3, max = 50, message = "Author name should be at least 3 and at most 50 symbols long!")
    private String author;

    @NonNull
    @NotNull(message = "Creation Date can not be null!")
    private LocalDate creationDate;

}
