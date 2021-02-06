package softuni.library.models.dtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorCreateDto {
    @Expose
    @NotNull
    @Size(min = 2)
    private String firstName;

    @Expose
    @NotNull
    @Size(min = 2)
    private String lastName;

    @Expose
    @NotNull
    @Size(min = 3, max = 12)
    private String birthTown;
}
