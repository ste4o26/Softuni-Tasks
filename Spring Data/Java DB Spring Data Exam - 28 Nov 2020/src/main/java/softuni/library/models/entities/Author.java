package softuni.library.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity(name = "authors")
@Table(name = "authors")
public class Author extends BaseEntity {

    @NotNull
    @Size(min = 2)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 2)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    //TODO look for the exclusive value!!!
    //TODO now i think it work inclusively from both sides
    @NotNull
    @Size(min = 3, max = 12)
    @Column(name = "birth_town", nullable = false)
    private String birthTown;


    @OneToMany(targetEntity = Book.class, mappedBy = "author")
    private Set<Book> books;
}
