package com.nathan_html.calendar_git.dao;

import com.nathan_html.calendar_git.model.Day;
import com.nathan_html.calendar_git.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionDAO extends JpaRepository<Reaction, Long> {
}
