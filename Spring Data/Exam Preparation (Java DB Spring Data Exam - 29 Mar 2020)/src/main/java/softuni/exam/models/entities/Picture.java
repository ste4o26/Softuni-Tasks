package softuni.exam.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity(name = "pictures")
@Table(name = "pictures")
public class Picture extends BaseEntity {

    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;

    @Size(min = 2, max = 20)
    @Column(name = "name", unique = true)
    private String name;

    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @ManyToMany(targetEntity = Offer.class, mappedBy = "pictures")
    private Set<Offer> offers;
}
