package car_dealer.domain.dtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierCreateDto {
    @Expose
    @NonNull
    @NotNull(message = "Supplier name can not be null!")
    private String name;

    @Expose
    @NonNull
    @NotNull(message = "Is importer field can not be null!")
    private boolean isImporter;
}
