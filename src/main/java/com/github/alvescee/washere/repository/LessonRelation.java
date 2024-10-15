package com.github.alvescee.washere.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.alvescee.washere.model.Lesson;

public interface LessonRelation extends JpaRepository<Lesson, UUID> {

    @Query("SELECT l FROM Lesson l WHERE l.day = :day AND l.month = :month")
    public Optional<Lesson> findLessonByDayAndMonth(@Param("day") int day, @Param("month") int month);

    @Override
    @Query("SELECT l FROM Lesson l ORDER BY l.month, l.day ASC")
    public List<Lesson> findAll();
    
}