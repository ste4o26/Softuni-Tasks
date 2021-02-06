package json_demo_lab.domain.dtos;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDeleteDto {

    @NonNull
    @NotNull(message = "Title can not be null!")
    @Size(min = 5, max = 80, message = "Title should be at least 5 and at most 80 symbols long!")
    private String title;
}
