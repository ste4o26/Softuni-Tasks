package entities.hospital_database;

import javax.persistence.*;
import java.util.Set;

//@Entity(name = "diagnose")
//@Table(name = "diagnoses")
public class Diagnose extends BaseEntity{
    private String name;
    String comment;
    Set<Patient> patients;

    public Diagnose() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToMany(targetEntity = Patient.class)
    @JoinTable(
            name = "diagnoses_patients",
            joinColumns = @JoinColumn(name = "diagnose_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"))
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
