package softuni.library.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity(name = "libraries")
@Table(name = "libraries")
public class Library extends BaseEntity {

    @NotNull
    @Size(min = 3)
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotNull
    @Size(min = 5)
    @Column(name = "location", nullable = false)
    private String location;

    @Min(value = 1)
    @Max(value = 10)
    @Column(name = "rating")
    private Integer rating;

    @ManyToMany(targetEntity = Book.class, fetch = FetchType.EAGER)
    @JoinTable(name = "libraries_books",
            joinColumns = @JoinColumn(name = "library_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    private Set<Book> books;
}
