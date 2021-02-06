package softuni.exam.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "seller")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerCreateDto {

    @NonNull
    @NotNull
    @Size(min = 2, max = 20)
    @XmlElement(name = "first-name")
    private String firstName;

    @NonNull
    @NotNull
    @Size(min = 2, max = 20)
    @XmlElement(name = "last-name")
    private String lastName;

    //TODO maight be incorrect
    @NonNull
    @NotNull
    @Email(regexp = "[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,3}")
    @XmlElement(name = "email")
    private String email;

    @NonNull
    @NotNull
    @XmlElement(name = "rating")
    private String rating;

    @NonNull
    @NotNull
    @XmlElement(name = "town")
    private String town;
}
