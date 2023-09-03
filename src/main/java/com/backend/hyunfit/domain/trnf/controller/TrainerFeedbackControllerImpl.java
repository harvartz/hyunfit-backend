package com.backend.hyunfit.domain.trnf.controller;

import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import com.backend.hyunfit.domain.trnf.service.TrainerFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/trainer-feedbacks")
@RestController
@RequiredArgsConstructor
public class TrainerFeedbackControllerImpl implements TrainerFeedbackController{

    private final TrainerFeedbackService trainerFeedbackService;

    @Override
    @PostMapping
    public TrainerFeedbackDTO createFeedback(@RequestBody TrainerFeedbackDTO feedbackDTO) {
        return trainerFeedbackService.insertFeedback(feedbackDTO);
    }
    ///127.0.0.1:8000

    @Override
    @PostMapping("/update-feedback")
    public ResponseEntity<String> updateFeedback(@RequestBody TrainerFeedbackDTO dto) {
        trainerFeedbackService.updateFeedback(dto.getContent());
        return new ResponseEntity<>("Feedback Updated Successfully", HttpStatus.OK);
    }

}
