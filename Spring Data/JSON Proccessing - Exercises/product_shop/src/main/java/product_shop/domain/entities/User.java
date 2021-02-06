package product_shop.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name = "users")
@Table(name = "users")
public class User extends BaseEntity {
    private Integer age;
    private String firstName;
    private String lastName;
    private Set<User> friends;

    public User() {
    }

    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "first_name", nullable = true)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull(message = "User last name can not be null!")
    @Size(min = 3, message = "User last name must be at least 3 characters long!")
    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }
}
