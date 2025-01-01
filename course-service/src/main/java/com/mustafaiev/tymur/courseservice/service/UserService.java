package com.mustafaiev.tymur.courseservice.service;

import com.mustafaiev.tymur.courseservice.entity.User;
import com.mustafaiev.tymur.courseservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Метод для поиска пользователя по имени
    public User findByName(String name) {
        // Используем репозиторий для поиска пользователя по имени
        return userRepository.findByName(name).orElse(null); // Возвращаем null, если пользователь не найден
    }

    // Метод для сохранения нового пользователя
    @Transactional
    public User save(User user) {
        return userRepository.save(user); // Сохраняем пользователя в базе данных
    }
}
