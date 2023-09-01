package com.backend.hyunfit.domain.erm.dto;

import com.backend.hyunfit.domain.exc.dto.ExerciseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErmDTO {
    private long rtnSeq;
    private long excSeq;

    public static List<ErmDTO> listFrom(long rtnSeq, List<ExerciseDTO> exercises) {
        return exercises.stream()
                .map(t -> new ErmDTO(rtnSeq, t.getExcSeq()))
                .toList();
    }
}
