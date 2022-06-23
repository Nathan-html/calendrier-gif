package com.nathan_html.calendar_git.service;

import com.nathan_html.calendar_git.dao.EmotionDAO;
import com.nathan_html.calendar_git.model.Emotion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmotionService {

    private EmotionDAO emotionDao;

    public List<Emotion> getEmotions() {
        return emotionDao.findAll();
     };

    public Emotion addEmotion(String code, String nom) {
        Emotion emotion = new Emotion(nom, code);
        return emotionDao.save(emotion);
    };

}
