package com.nathan_html.calendar_gif.dao;

import com.nathan_html.calendar_gif.model.Day;
import com.nathan_html.calendar_gif.model.Emotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionDAO  extends JpaRepository<Emotion, Long> {
}
