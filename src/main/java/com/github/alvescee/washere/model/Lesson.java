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
public class Lesson implements Serializable {
 
    private static final long serialVersionUID = 1L;

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int day;
    private int month;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lesson")
    private List<Presence> presences;

    // Constructor

    public Lesson() {}

    // Getter

    public UUID getId() {
        return id;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public List<Presence> getPresences() {
        return presences;
    }

    // Setter

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    /** Equals compare if the Lesson has the same day in same month
    */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + day;
        result = prime * result + month;
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
        Lesson other = (Lesson) obj;
        if (day != other.day)
            return false;
        if (month != other.month)
            return false;
        return true;
    }

}