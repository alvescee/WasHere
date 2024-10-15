package com.github.alvescee.washere.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.alvescee.washere.model.Presence;

public interface PresenceRelation extends JpaRepository<Presence, UUID> {}