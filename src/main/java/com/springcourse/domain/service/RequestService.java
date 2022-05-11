package com.springcourse.domain.service;

import com.springcourse.domain.entity.Request;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RequestService {

    private RequestRepository requestRepository;

    public Request save(Request request){
        request.setState(RequestState.OPEN);
        request.setCreationDate(new Date());

        Request createdRequest = requestRepository.save(request);
        return createdRequest;
    }

    public Request update(Request request){
        Request updateRequest = requestRepository.save(request);
        return updateRequest;
    }

    public Request getById(Long id){
        Optional<Request> result = requestRepository.findById(id);
        return result.get();
    }

    public List<Request> listAll(){
        List<Request> requests = requestRepository.findAll();
        return requests;
    }

    public List<Request> listAllByOwnerId(Long ownerId){
        List<Request> requests = requestRepository.findAllByOwnerId(ownerId);
        return requests;
    }


}
