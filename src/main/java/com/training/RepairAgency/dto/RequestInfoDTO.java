package com.training.RepairAgency.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestInfoDTO {

    long id;

    String master;

    long price;

    String  reason;
}
