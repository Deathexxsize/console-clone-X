package org.example.service;

import org.example.dao.UserDao;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void createUser(User user) {
        userDao.save(user);
    }

    public boolean userExists(String username, String password) {
        if (userDao.existsByUsername(username)) {
            if (userDao.existsByPassword(password)) {
                return true;
            }
        }
        return false;
    }
}
