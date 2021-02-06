package car_dealer.domain.dtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartCreateDto {
    @Expose
    @NonNull
    @NotNull(message = "Part name can not be null!")
    private String name;

    @Expose
    @NonNull
    @NotNull(message = "Part price can not be null!")
    private BigDecimal price;

    @Expose
    @NonNull
    @NotNull(message = "Part quantity can not be null!")
    private Integer quantity;
}
