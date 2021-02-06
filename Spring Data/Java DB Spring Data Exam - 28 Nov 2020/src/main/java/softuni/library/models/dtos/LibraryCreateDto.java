package softuni.library.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "library")
@XmlAccessorType(XmlAccessType.FIELD)
public class LibraryCreateDto {

    @NotNull
    @Size(min = 3)
    @XmlElement(name = "name")
    private String name;

    @NotNull
    @Size(min = 5)
    @XmlElement(name = "location")
    private String location;

    @Min(value = 1)
    @Max(value = 10)
    @XmlElement(name = "rating")
    private Integer rating;

    @XmlElement(name = "book")
    private BookIdDto book;
}
