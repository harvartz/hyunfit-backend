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
    @PostMapping("/gpt")
    public ResponseEntity<TrainerFeedbackDTO> getGptFeedback(@RequestBody TrainerFeedbackDTO dto) {
        TrainerFeedbackDTO gptResult = trainerFeedbackService.getGptFeedback(dto.getContent());
        return ResponseEntity.ok(gptResult);
    }

}
