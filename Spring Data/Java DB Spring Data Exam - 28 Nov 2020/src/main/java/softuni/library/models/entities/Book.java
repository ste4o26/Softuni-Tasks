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
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity(name = "books")
@Table(name = "books")
public class Book extends BaseEntity {

    @NotNull
    @Size(min = 5)
    @Column(name = "name", nullable = false)
    private String name;

    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "edition")
    private Integer edition;

    @NotNull
    @Column(name = "written", nullable = false)
    private LocalDate written;

    @NotNull
    @Size(min = 100)
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne(targetEntity = Author.class)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @ManyToMany(targetEntity = Library.class, mappedBy = "books")
    private Set<Library> libraries;

    @OneToMany(targetEntity = Character.class, mappedBy = "book")
    private Set<Character> characters;
}
