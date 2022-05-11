package com.springcourse.repository;

import com.springcourse.domain.entity.User;
import com.springcourse.domain.enums.Role;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UserRepositoryTests {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void AsaveTest(){
        User user = new User(null, "Kevin", "kevin.wingin@gmail.com", "123", Role.ADMINISTRATOR, null, null);
        User created = userRepository.save(user);

        //act
        assert(created.getId()).equals(1L);
    }

    @Test
    public void updateTest(){
        User user = new User(1L, "Kevin Wingi", "kevin.wingin@gmail.com", "123", Role.ADMINISTRATOR, null, null);
        User updatedUser = userRepository.save(user);

        //act
        assert(updatedUser.getName()).equals("Kevin Wingi");
    }

    @Test
    public void getByIdTest(){
        Optional<User> result = userRepository.findById(1L);
        User user = result.get();

        //act
        assert(user.getPassword()).equals("123");

    }

    @Test
    public void listTest(){
        List<User> users = userRepository.findAll();

        //act
        assert(users.get(0).getId()).equals(1L);

    }

    @Test
    public void loginTest(){
        Optional<User> result = userRepository.login("kevin.wingin@gmail.com", "123");
        User loggedUser = result.get();

        //act
        assert(loggedUser.getId()).equals(1L);
    }
}
