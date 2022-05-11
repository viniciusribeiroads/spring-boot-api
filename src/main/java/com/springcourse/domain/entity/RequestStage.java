package com.springcourse.domain.entity;

import com.springcourse.domain.enums.RequestState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "request_stage")
public class RequestStage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "creation_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date realizationDate;
    @Column(length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestState stage;
    @ManyToOne
    @JoinColumn(name = "request_id", nullable=false)
    private Request request;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable=false)
    private User owner;
}
