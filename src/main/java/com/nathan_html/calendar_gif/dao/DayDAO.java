package com.nathan_html.calendar_git.dao;

import com.nathan_html.calendar_git.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayDAO extends JpaRepository<Day, Long> {

}
