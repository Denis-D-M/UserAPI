package com.epam.mishin.service;

import com.epam.mishin.domain.entity.User;
import com.epam.mishin.domain.entity.UserStatus;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findOnline(Boolean online);

    List<User> findAll();
//возвращать dto, не optional
    Optional<User> findUserById(int id);

    User saveUser(User user);

    void updateStatus(int userId, UserStatus newStatus);
}
