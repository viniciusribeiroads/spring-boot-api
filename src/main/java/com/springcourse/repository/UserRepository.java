package com.springcourse.repository;

import com.springcourse.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByName(String name);

    public User findByEmail(String email);

    @Query("SELECT FROM User WHERE email = ?1 AND password = ?2")
    public Optional<User> login(String email, String password);


}
