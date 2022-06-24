package com.nathan_html.calendar_gif.dao.User;

import com.nathan_html.calendar_gif.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);
}
