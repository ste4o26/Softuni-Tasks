package json_demo_lab.domain.dtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostViewDto {
    @Expose
    @NonNull
    @NotNull
    private Long id;

    @Expose
    @NonNull
    @NotNull
    private String title;

    @Expose
    @NonNull
    @NotNull
    private String content;

    @Expose
    @NonNull
    @NotNull
    private String author;
}
