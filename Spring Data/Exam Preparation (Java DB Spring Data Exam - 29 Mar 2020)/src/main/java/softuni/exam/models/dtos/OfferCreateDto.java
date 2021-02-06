package softuni.exam.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import softuni.exam.config.LocalDateTimeAdapter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferCreateDto {

    @NonNull
    @NotNull
    @Size(min = 5)
    @XmlElement(name = "description")
    private String description;

    @NonNull
    @NotNull
    @Min(value = 0)
    @XmlElement(name = "price")
    private BigDecimal price;

    @NonNull
    @NotNull
    @XmlElement(name = "added-on")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime addedOn;

    @NonNull
    @NotNull
    @XmlElement(name = "has-gold-status")
    private boolean hasGoldStatus;

    @NonNull
    @NotNull
    @XmlElement(name = "car")
    private CarIdHolderDto car;

    @NonNull
    @NotNull
    @XmlElement(name = "seller")
    private SellerIdHolderDto seller;
}
