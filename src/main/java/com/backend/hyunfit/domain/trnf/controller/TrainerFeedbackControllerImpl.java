package com.backend.hyunfit.domain.trnf.controller;

import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import com.backend.hyunfit.domain.trnf.service.TrainerFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/127.0.0.1:8000")
@RestController
@RequiredArgsConstructor
public class TrainerFeedbackControllerImpl implements TrainerFeedbackController{

    private final TrainerFeedbackService trainerFeedbackService;

    @Override
    @PostMapping("/trainer-feedbacks")
    public TrainerFeedbackDTO createFeedback(@RequestBody TrainerFeedbackDTO feedbackDTO) {
        return trainerFeedbackService.insertFeedback(feedbackDTO);
    }

}
