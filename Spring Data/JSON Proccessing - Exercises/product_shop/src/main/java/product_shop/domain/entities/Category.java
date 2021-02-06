package product_shop.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "categories")
@Table(name = "categories")
public class Category extends BaseEntity{
    private String name;

    public Category() {
    }

    @Column(name = "name", nullable = false)
    @NotNull(message = "Category name can not be null!")
    @Size(min = 3, max = 15, message = "Product name must be between 3 and 15 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
