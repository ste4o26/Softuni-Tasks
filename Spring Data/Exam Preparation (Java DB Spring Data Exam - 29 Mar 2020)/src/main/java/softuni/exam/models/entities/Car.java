package softuni.exam.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity(name = "cars")
@Table(name = "cars")
public class Car extends BaseEntity {

    //TODO The combination of make, model and kilometers makes a car unique.

    @Min(1)
    @Column(name = "kilometers")
    private Integer kilometers;

    @Size(min = 2, max = 20)
    @Column(name = "make")
    private String make;

    @Size(min = 2, max = 20)
    @Column(name = "model")
    private String model;

    @Column(name = "registered_on")
    private LocalDate registeredOn;

    @OneToMany(targetEntity = Picture.class, mappedBy = "car", fetch = FetchType.EAGER)
    private Set<Picture> pictures;

    @OneToMany(targetEntity = Offer.class, mappedBy = "car", fetch = FetchType.EAGER)
    private Set<Offer> offers;
}
