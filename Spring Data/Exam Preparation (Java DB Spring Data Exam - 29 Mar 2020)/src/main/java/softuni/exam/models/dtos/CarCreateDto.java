package softuni.exam.models.dtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarCreateDto {
    @Expose
    @NonNull
    @NotNull
    @Size(min = 2, max = 20)
    private String make;

    @Expose
    @NonNull
    @NotNull
    @Size(min = 2, max = 20)
    private String model;

    @Expose
    @NonNull
    @NotNull
    @Min(value = 0)
    private Integer kilometers;

    @Expose
    @NonNull
    @NotNull
    private LocalDate registeredOn;
}
