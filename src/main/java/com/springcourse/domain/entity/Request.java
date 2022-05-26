package com.springcourse.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springcourse.domain.enums.RequestState;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
@Setter
@Entity(name = "request")
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75, nullable = false)
    private String subject;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "creation_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestState state;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(mappedBy = "request")
    private List<RequestStage> stages = new ArrayList<>();


}
