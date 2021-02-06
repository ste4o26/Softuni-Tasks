package application.domain.entities;

import javax.persistence.*;

@Entity(name = "labels")
public class Label extends BaseEntity {

    private String title;
    private String subtitle;
    private Shampoo shampoo;

    public Label() {
    }

    @Column(name = "title")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "subtitle")
    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @OneToOne(mappedBy = "label",
            targetEntity = Shampoo.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    public Shampoo getShampoo() {
        return this.shampoo;
    }

    public void setShampoo(Shampoo shampoo) {
        this.shampoo = shampoo;
    }
}
