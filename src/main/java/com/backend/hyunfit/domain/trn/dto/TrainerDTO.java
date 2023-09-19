package com.backend.hyunfit.domain.trn.dto;

import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import com.backend.hyunfit.domain.ptr.dto.PtrDTO;
import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainerDTO {
    private long trnSeq;
    private String trnId;
    private String trnPw;
    private String trnName;
    private int trnType;
    private String trnTypeName;
    private String trnShortDescription;
    private String trnAbout;
    private Integer trnGender;
    private int trnExperienceYear;
    private String trnAvailableTime;
    private String trnProfileUrl;
    private int trnPtCount;
    private double averageReviewRating;
    private int reviewCount;
    private double fireScore;
    private List<TrainerFeedbackDTO> noFeedbackList;
    private List<PersonalTrainingDTO> ptList;
    private List<PtrDTO> reviews;
}