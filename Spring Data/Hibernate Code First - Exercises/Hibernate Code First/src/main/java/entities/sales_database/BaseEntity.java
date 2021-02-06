package entities.sales_database;

import javax.persistence.*;

//@MappedSuperclass
public abstract class BaseEntity {
    protected int id;

    protected BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }
}
