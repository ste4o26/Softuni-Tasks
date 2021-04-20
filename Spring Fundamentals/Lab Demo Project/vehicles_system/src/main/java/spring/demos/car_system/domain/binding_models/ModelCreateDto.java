package spring.demos.car_system.domain.binding_models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModelCreateDto {

    @NonNull
    @NotNull
    private String name;

    @NonNull
    @NotNull
    private String imageUrl;

    private LocalDateTime created;

    private LocalDateTime modified;

    @NonNull
    @NotNull
    private String brandName;

    @NonNull
    @NotNull
    private Integer startYear;

    @NonNull
    @NotNull
    private Integer endYear;
}
