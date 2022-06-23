package com.nathan_html.calendar_git.dao;

import com.nathan_html.calendar_git.model.Day;
import com.nathan_html.calendar_git.model.Emotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionDAO  extends JpaRepository<Emotion, Long> {
}
