package com.backend.hyunfit.domain.trnf.service;

import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;

public interface TrainerFeedbackService {
    TrainerFeedbackDTO insertFeedback(TrainerFeedbackDTO feedbackDTO);
}
