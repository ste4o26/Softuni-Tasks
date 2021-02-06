package entities.hospital_database;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
    protected long id;

    protected BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }
}
