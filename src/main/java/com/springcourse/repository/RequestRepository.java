package com.springcourse.repository;

import com.springcourse.domain.entity.Request;
import com.springcourse.domain.enums.RequestState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {


    public List<Request> findAllByOwnerId(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE request SET state = ?2 WHERE id = ?1")
    public int updateStatus(Long id, RequestState state);

}
