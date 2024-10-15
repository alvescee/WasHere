package com.github.alvescee.washere.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private int chip;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Presence> presences;
    
    // Constructor

    public Student () {}

    // Getter

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getChip() {
        return chip;
    }

    public List<Presence> getPresences() {
        return presences;
    }

    // Setter

    public void setName(String name) {
        this.name = name;
    }

    public void setChip(int chip) {
        this.chip = chip;
    }

    /** Equals compare if the Student has the same id of the chip
    */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + chip;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (chip != other.chip)
            return false;
        return true;
    }

}