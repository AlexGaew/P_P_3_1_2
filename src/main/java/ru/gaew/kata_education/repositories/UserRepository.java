package ru.gaew.kata_education.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gaew.kata_education.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
