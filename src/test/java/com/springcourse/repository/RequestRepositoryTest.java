package com.springcourse.repository;

import com.springcourse.domain.entity.Request;
import com.springcourse.domain.entity.User;
import com.springcourse.domain.enums.RequestState;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.FixedWidth;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RequestRepositoryTest {
    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void AsaveTest() {
        Optional<User> userOwner = userRepository.findById(1L);
        User user = userOwner.get();

        com.springcourse.domain.entity.Request request = new com.springcourse.domain.entity.Request(null, "Laptop HP", "Novo laptop", new Date(), RequestState.OPEN, user, null);

        Request created = requestRepository.save(request);

        //act
        assert(created.getId()).equals(1L);
    }
    @Test
    public void updateTest() {
        User userOwner = new User();
        userOwner.setId(1L);

        com.springcourse.domain.entity.Request request = new com.springcourse.domain.entity.Request(1L, "Laptop Lenovo", "Novo laptop", null, RequestState.OPEN, userOwner, null);

        Request updatedRequest = requestRepository.save(request);

        //act
        assert(updatedRequest.getSubject()).equals("Laptop Lenovo");

    }
    @Test
    public void getByIdTest() {
        Optional<Request> result = requestRepository.findById(1L);
        Request request = result.get();

        //act
        assert(request.getSubject()).equals("Laptop Lenovo");
    }
    @Test
    public void listTest() {
        List<Request> requests = requestRepository.findAll();

        //act
        assert(requests.get(0).getId()).equals(1L);
    }
    @Test
    public void listByOwnerIdTest(){
        List<Request> requests = requestRepository.findAllByOwnerId(1L);

        //act
        assert(requests.size()==1);
    }

}
