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

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity(name = "characters")
@Table(name = "characters")
public class Character extends BaseEntity {
    @NotNull
    @Size(min = 3)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @NotNull
    @Size(min = 3)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Min(value = 10)
    @Max(value = 66)
    @Column(name = "age", nullable = false)
    private Integer age;

    @NotNull
    @Size(min = 5)
    @Column(name = "role", nullable = false)
    private String role;

    @NotNull
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
}
