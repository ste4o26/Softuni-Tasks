package json_demo_lab.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity(name = "users")
//@Table(name = "users")
public class User {

    @NonNull
    @NotNull(message = "Name can not be null!")
    @Size(min = 3, max = 50)
    @Column(name = "name", length = 50)
    private String name;

}
