package com.springcourse.domain.service;

import com.springcourse.domain.entity.Request;
import com.springcourse.domain.entity.RequestStage;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.domain.exception.NotFoundException;
import com.springcourse.repository.RequestRepository;
import com.springcourse.repository.RequestStageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RequestStageService {

    private RequestStageRepository requestStageRepository;
    private RequestRepository requestRepository;

    public RequestStage save(RequestStage stage){
        stage.setRealizationDate(new Date());

        RequestStage createdStage = requestStageRepository.save(stage);

        Long requestId = stage.getRequest().getId();
        RequestState state = stage.getState();

        requestRepository.updateStatus(requestId, state);
        return createdStage;
    }

    public RequestStage getBy(Long id){
        Optional<RequestStage> result = requestStageRepository.findById(id);
        return result.orElseThrow(()-> new NotFoundException("There are not request stage with id = " + id));
    }

    public List<RequestStage> listAllByRequestId(Long requestId){
        List<RequestStage> stages = requestStageRepository.findAllByRequestId(requestId);
        return stages;
    }




}
