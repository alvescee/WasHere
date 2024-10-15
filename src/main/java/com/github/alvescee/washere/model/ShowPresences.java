package com.github.alvescee.washere.model;

import java.util.List;

/**
 * @param day is the day of the class
 * @param month is the same of the day
 * @param present is the presences of a class
*/
public record ShowPresences(String day, String month, List<SimplePresence> presences) {}