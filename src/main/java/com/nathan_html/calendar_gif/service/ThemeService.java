package com.nathan_html.calendar_gif.service;

import com.nathan_html.calendar_gif.dao.ThemeDAO;
import com.nathan_html.calendar_gif.model.Theme;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ThemeService {

    private ThemeDAO themeDAO;

    public List<Theme> getThemes() {
        return themeDAO.findAll();
    };

    public Theme addTheme(Theme theme) {
        return themeDAO.save(theme);
    };
}
