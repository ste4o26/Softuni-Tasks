package entities.hospital_database;

import javax.persistence.*;
import java.util.Set;

//@Entity(name = "medicament")
//@Table(name = "medicaments")
public class Medicament extends BaseEntity {
    private String name;
    private Set<Patient> patients;

    public Medicament() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(targetEntity = Patient.class)
    @JoinTable(
            name = "medicaments_patients",
            joinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"))
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
