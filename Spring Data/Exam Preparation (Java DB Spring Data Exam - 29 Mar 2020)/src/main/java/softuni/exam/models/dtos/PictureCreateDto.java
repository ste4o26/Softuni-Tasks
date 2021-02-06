package softuni.exam.models.dtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PictureCreateDto {
    @Expose
    @NonNull
    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    @NonNull
    @NotNull
    @Expose
    private LocalDateTime dateAndTime;

    @NonNull
    @NotNull
    @Expose
    private Long car;
}
