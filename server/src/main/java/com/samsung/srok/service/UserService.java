package com.samsung.srok.service;

import com.samsung.srok.domain.User;

import java.util.List;

public interface UserService {
    User add(User user);

    List<User> getAll();

    User getById(long id);

    User update(long id, User user);

    void deleteById(long id);
}

