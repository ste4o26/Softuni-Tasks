package json_demo_lab.domain.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "posts")
@Table(name = "posts")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private Long id;

    @NonNull
    @NotNull
    @Size(min = 5, max = 80)
    @Column(name = "title", length = 80)
    private String title;

    @NonNull
    @NotNull
    @Size(min = 20, max = 1000)
    @Column(name = "content", length = 1000, columnDefinition = "TEXT")
    private String content;

    @NonNull
    @NotNull
    @Column(name = "image_url")
    private String imageUrl;

    @NonNull
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "author")
    private String author;

    @NonNull
    @NotNull
    @Column(name = "creation_date")
    private LocalDate creationDate;
}
