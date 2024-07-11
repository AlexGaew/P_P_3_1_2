package ru.gaew.kata_education.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gaew.kata_education.model.User;
import ru.gaew.kata_education.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow();
    }

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void update(User user, long id) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);
        } else throw new EntityNotFoundException("User with id " + id + " not found");

    }

    @Transactional
    @Override
    public void delete(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else throw new EntityNotFoundException("User with id " + id + " not found");

    }
}
