package com.springcourse.domain.service;

import com.springcourse.domain.entity.User;
import com.springcourse.domain.exception.NotFoundException;
import com.springcourse.domain.util.HashUtil;
import com.springcourse.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User save(User user){
        String hash = HashUtil.getSecurityHash(user.getPassword());
        user.setPassword(hash);
        User created = userRepository.save(user);
        return user;
    }

    public User update(User user){
        String hash = HashUtil.getSecurityHash(user.getPassword());
        user.setPassword(hash);
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    public User getById(Long id){
        Optional<User> result = userRepository.findById(id);
        return result.orElseThrow( () -> new NotFoundException("There are not user with id = " + id));
    }

    public List<User> findAll(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public User login (String email, String password){
        password = HashUtil.getSecurityHash(password);
        Optional<User> result = userRepository.login(email,password);
        return result.get();
    }
}
