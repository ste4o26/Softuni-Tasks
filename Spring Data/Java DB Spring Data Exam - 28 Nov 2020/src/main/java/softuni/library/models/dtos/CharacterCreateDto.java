package softuni.library.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softuni.library.config.LocalDateAdapter;
import softuni.library.models.entities.Book;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "character")
@XmlAccessorType(XmlAccessType.FIELD)
public class CharacterCreateDto {

    @NotNull
    @Size(min = 3)
    @XmlElement(name = "first-name")
    private String firstName;

    @NotNull
    @Size(max = 1)
    @XmlElement(name = "middle-name")
    private String middleName;

    @NotNull
    @Size(min = 3)
    @XmlElement(name = "last-name")
    private String lastName;

    @NotNull
    @Min(value = 10)
    @Max(value = 66)
    @XmlElement(name = "age")
    private Integer age;

    @NotNull
    @Size(min = 5)
    @XmlElement(name = "role")
    private String role;

    @NotNull
    @XmlElement(name = "birthday")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate birthday;

    @XmlElement(name = "book")
    private BookIdDto book;
}
