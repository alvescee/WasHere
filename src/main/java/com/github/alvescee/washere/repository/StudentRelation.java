package com.github.alvescee.washere.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.alvescee.washere.model.Student;

public interface StudentRelation extends JpaRepository<Student, UUID> {

    public Optional<Student> findByChip(long chip);

}