package com.ust.StateServices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Districtdto {
    private Long id;
    private String districtName;
    private String stateId;
}
