package com.nathan_html.calendar_git.dao.User;

import com.nathan_html.calendar_git.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);
}
