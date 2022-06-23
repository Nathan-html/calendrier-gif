package com.nathan_html.calendar_git.dao;

import com.nathan_html.calendar_git.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeDAO  extends JpaRepository<Theme, Long> {
}
