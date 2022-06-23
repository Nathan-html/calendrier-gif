package com.nathan_html.calendar_git.service;

import com.nathan_html.calendar_git.dao.DayDAO;
import com.nathan_html.calendar_git.model.Day;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DayService {

    private DayDAO dayDAO;

    public Page<Day> getDays(Pageable pageable) {
        return dayDAO.findAll(pageable);
    };

    public Day addDay(Day day) {
        return dayDAO.save(day);
    };
}
