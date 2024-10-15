package com.github.alvescee.washere.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.alvescee.washere.model.Lesson;

public interface LessonRelation extends JpaRepository<Lesson, UUID> {}