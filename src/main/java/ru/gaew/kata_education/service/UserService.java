package ru.gaew.kata_education.service;


import ru.gaew.kata_education.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getUserById(long id);


    void save(User user);


    void update(User user, long id);


    void delete(long id);
}
