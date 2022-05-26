package com.springcourse.repository;

import com.springcourse.domain.entity.Request;
import com.springcourse.domain.entity.RequestStage;
import com.springcourse.domain.entity.User;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.domain.enums.Role;
import org.junit.FixMethodOrder;
import org.junit.Test;
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
public class RequestStageRepositoryTest {

    @Autowired
    private RequestStageRepository requestStageRepository;

    @Test
    public void AsaveTest(){
        User owner = new User();
        owner.setId(1L);

        Request request = new Request();
        request.setId(1L);

        RequestStage stage = new RequestStage(null, "Foi comprado um novo laptop de marca HD e com 16 GB de RAM", new Date(), RequestState.CLOSE, request, owner);

        RequestStage createdStage = requestStageRepository.save(stage);

        assert(createdStage.getId()==(1));
    }
    @Test
    public void getByIdTest(){
        Optional<RequestStage> result = requestStageRepository.findById(1L);
        RequestStage stage = result.get();

        //act
        assert(stage.getDescription()).equals("Foi comprado um novo laptop de marca HP e com 16GB de RAM");
    }
    @Test
    public void listByRequestIdTest(){

        List<RequestStage> stages = requestStageRepository.findAllByRequestId(1L);

        //act
        assert(stages.size()==1);
    }
}
