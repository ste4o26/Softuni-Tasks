package softuni.library.models.dtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateDto {
    @Expose
    @NotNull
    @Size(min = 100)
    private String description;

    @Expose
    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private Integer edition;

    @Expose
    @NotNull
    @Size(min = 5)
    private String name;

    @Expose
    @NotNull
    private LocalDate written;

    @Expose
    @NotNull
    private Long author;
}
