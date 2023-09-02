package com.backend.hyunfit.domain.mbr.dto;

import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
    private long mbrSeq;
    private String mbrId;
    private String mbrPw;
    private String mbrName;
    private int mbrTotalPoint;
    private int mbrTotalExp;
    private Timestamp mbrBirthdate;
    private String mbrGender;
    private double mbrHeight;
    private double mbrWeight;
    private String mbrExerciseGoal;
    private String mbrExerciseExperienceLevel;
    private String mbrExercisePreference;
    private String mbrKneeHealth;
    private String mbrNoiseConsideration;
    private int mbrSittingDuration;
    private String mbrNeckShoulderFocused;
    private List<PersonalTrainingDTO> personalTrainingDTOList;
}
