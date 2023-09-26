package com.backend.hyunfit.domain.trnf.dto;

import com.backend.hyunfit.domain.exc.dto.ExerciseInTargetDTO;
import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainerFeedbackDTO {
    private Long trnfSeq;
    private Long trnSeq;
    private Long mbrSeq;
    private String mbrName;
    private String trnfContent;
    private Timestamp trnfCreationDate;
    private Timestamp trnfWrittenDate;
    private Timestamp trnfReportModDate;
    private Timestamp trnfSubmissionDue;
    private String targetMonth;
    private String content;
    private MemberDTO gptData;
}
