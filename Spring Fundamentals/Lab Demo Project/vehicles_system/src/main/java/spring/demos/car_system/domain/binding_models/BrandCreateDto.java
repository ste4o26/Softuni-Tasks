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
public class BrandCreateDto {

    @NonNull
    @NotNull
    private String name;

    private LocalDateTime created;

    private LocalDateTime modified;
}
