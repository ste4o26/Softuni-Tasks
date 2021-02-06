package car_dealer.domain.dtos;

import com.google.gson.annotations.Expose;

public class SaleViewDto {
    @Expose
    private Long id;

    public SaleViewDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
