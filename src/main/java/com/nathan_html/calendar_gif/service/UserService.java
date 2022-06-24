package com.nathan_html.calendar_gif.service;

import com.nathan_html.calendar_gif.dao.User.UserDAO;
import com.nathan_html.calendar_gif.model.User.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserDAO userDAO;

    public User login(String email, String password) {
        return userDAO.findByEmailAndPassword(email, password);
    };

    public User addUser(User user) {
        return userDAO.save(user);
    };
}
