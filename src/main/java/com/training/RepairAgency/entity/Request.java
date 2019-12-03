package com.training.RepairAgency.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Builder
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String request;
    String status;
    Long price;
    String reason;
    String creator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id")
    User master;
}
