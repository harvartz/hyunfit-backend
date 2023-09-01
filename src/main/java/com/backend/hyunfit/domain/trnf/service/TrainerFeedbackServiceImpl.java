package com.backend.hyunfit.domain.trnf.service;

import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import com.backend.hyunfit.domain.trnf.mapper.TrainerFeedbackMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class TrainerFeedbackServiceImpl implements TrainerFeedbackService{

    private final TrainerFeedbackMapper trainerFeedbackMapper;

    @Override
    public TrainerFeedbackDTO insertFeedback(TrainerFeedbackDTO feedbackDTO) {
        trainerFeedbackMapper.insertFeedback(feedbackDTO);
        return feedbackDTO;
    }
}
