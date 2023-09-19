package com.backend.hyunfit.domain.trn.dto;

import com.backend.hyunfit.global.dto.SearchOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerSearchDTO {
    private List<Integer> trainerTypes;
    private int trnGender;
    private String keyword;
    private SearchOrder order;
    private int page;
}
