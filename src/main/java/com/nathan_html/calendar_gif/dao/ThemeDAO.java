package com.nathan_html.calendar_gif.dao;

import com.nathan_html.calendar_gif.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeDAO  extends JpaRepository<Theme, Long> {
}
