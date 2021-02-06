package softuni.exam.models.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity(name = "sellers")
@Table(name = "sellers")
public class Seller extends BaseEntity{

    @Email(regexp = "[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,3}")
    @Column(name = "email", unique = true)
    private String email;

    @Size(min = 2, max = 20)
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 2, max = 20)
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @NotNull(message = "Rating can not be null!")
    @Enumerated(EnumType.STRING)
    @Column(name = "rating")
    private Rating rating;

    @NonNull
    @NotNull(message = "Town can not be null!")
    @Column(name = "town")
    private String town;

    @OneToMany(targetEntity = Offer.class, mappedBy = "car", fetch = FetchType.EAGER)
    private Set<Offer> offers;
}
