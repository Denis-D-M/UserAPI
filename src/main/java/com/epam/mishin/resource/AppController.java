package com.epam.mishin.resource;

import com.epam.mishin.domain.entity.User;
import com.epam.mishin.domain.entity.UserStatus;
import com.epam.mishin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class AppController {

    private final UserService userService;

    @GetMapping
    public List<User> root(@RequestParam(required = false) Boolean online) {
        return userService.findOnline(online);
    }

    @GetMapping("/{id}")
    @Cacheable("users")
    public User byId(@PathVariable(value = "id") Integer id) {
        System.out.println("computing or I dunno");
        return userService.findUserById(id).orElseThrow(NullPointerException::new);
    }

    @PostMapping
    public User addNew(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody UserStatus status) {
        userService.updateStatus(id, status);
    }

}
