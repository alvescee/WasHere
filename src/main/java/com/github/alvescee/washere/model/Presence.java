package com.github.alvescee.washere.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Presence implements Serializable {

    private static final long serialVersionUID = 1L;

    // Attributes
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "is_present")
    private boolean isPresent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id", nullable=false)
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="lesson_id", nullable=false)
    private Lesson lesson;

    // Constructor

    public Presence () {}

    // Getter

    public UUID getId() {
        return id;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public Student getStudent() {
        return student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    // Setter

    public void setPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    /** Equals compare if the presence has the same Student and Lesson
    */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((student == null) ? 0 : student.hashCode());
        result = prime * result + ((lesson == null) ? 0 : lesson.hashCode());
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
        Presence other = (Presence) obj;
        if (student == null) {
            if (other.student != null)
                return false;
        } else if (!student.equals(other.student))
            return false;
        if (lesson == null) {
            if (other.lesson != null)
                return false;
        } else if (!lesson.equals(other.lesson))
            return false;
        return true;
    }

}