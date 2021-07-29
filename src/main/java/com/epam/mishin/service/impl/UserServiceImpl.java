package com.epam.mishin.service.impl;

import com.epam.mishin.domain.entity.User;
import com.epam.mishin.domain.entity.UserStatus;
import com.epam.mishin.repository.UserRepository;
import com.epam.mishin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<User> findOnline(Boolean online) {
        return Optional.ofNullable(online).map(onlineTrue -> {
            if (onlineTrue) {
                return repository.findByStatus(UserStatus.ONLINE);
            }
            return repository.findByStatus(UserStatus.OFFLINE);
        }).orElseGet(repository::findAll);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    //не optional, return dto
    public Optional<User> findUserById(int id) {
        return repository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public void updateStatus(int userId, UserStatus newStatus) {
        repository.updateUserStatus(userId, newStatus);
    }
}
