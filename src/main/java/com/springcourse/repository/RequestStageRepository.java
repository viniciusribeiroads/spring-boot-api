package com.springcourse.repository;

import com.springcourse.domain.entity.Request;
import com.springcourse.domain.entity.RequestStage;
import com.springcourse.domain.enums.RequestState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestStageRepository extends JpaRepository<RequestStage, Long> {

    public List<RequestStage> findAllByRequestId(Long id);


}
