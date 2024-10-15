package com.github.alvescee.washere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.alvescee.washere.model.Lesson;
import com.github.alvescee.washere.model.ShowPresences;
import com.github.alvescee.washere.model.SimplePresence;
import com.github.alvescee.washere.repository.LessonRelation;

@Controller
public class DashboardPath {
    
    @Autowired
    private LessonRelation lessonRelation;

    @GetMapping
    public ModelAndView all() {

        final ModelAndView view = new ModelAndView("dashboard.html");

        List<ShowPresences> show = lessonRelation.findAll().stream().map(lesson -> {
            return new ShowPresences(
                Integer.toString(lesson.getDay()), 
                Integer.toString(lesson.getMonth()), 
                this.extractListPresence(lesson)
            );
        }).toList();

        view.addObject("lessons", show);

        return view;
    }

    private List<SimplePresence> extractListPresence(Lesson lesson) {
        return lesson.getPresences().stream().map(presence -> {
            return new SimplePresence(presence.getStudent().getName(), presence.isPresent());
        }).toList();
    }
}