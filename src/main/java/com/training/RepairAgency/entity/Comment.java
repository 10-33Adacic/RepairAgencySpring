package com.training.RepairAgency.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDate date;
    String comment;

    @ManyToOne()
    User user;
//TODO: Delete this after test
//    @OneToOne
   // Request request;
}
