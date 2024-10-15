package com.github.alvescee.washere.model;

/**
 * @param student is the student name
 * @param present is the presence of the student in a class
*/
public record SimplePresence(String student, boolean present) {}