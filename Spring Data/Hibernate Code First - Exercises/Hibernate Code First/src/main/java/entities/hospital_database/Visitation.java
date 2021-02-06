package entities.hospital_database;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity(name = "visitation")
//@Table(name = "visitations")
public class Visitation extends BaseEntity {
    private LocalDate date;
    private String comment;
    private Patient patient;

    public Visitation() {
    }

    @Column(name = "date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "comment")
    public String getComments() {
        return comment;
    }

    public void setComments(String comments) {
        this.comment = comments;
    }

    @ManyToOne(targetEntity = Patient.class)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
