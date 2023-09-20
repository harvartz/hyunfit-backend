package com.backend.hyunfit.domain.trnf.controller;

import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import com.backend.hyunfit.domain.trnf.service.TrainerFeedbackService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/write-feedback")
    public ResponseEntity<TrainerFeedbackDTO> updateFeedback(@RequestBody TrainerFeedbackDTO feedbackDTO){
        trainerFeedbackService.updateFeedback(feedbackDTO);
        return ResponseEntity.ok(feedbackDTO);
    }

    @Override
    @PostMapping("/gpt")
    public ResponseEntity<TrainerFeedbackDTO> getGptFeedback(@RequestBody TrainerFeedbackDTO dto) {
        TrainerFeedbackDTO gptResult = trainerFeedbackService.getGptFeedback(dto.getContent());
        return ResponseEntity.ok(gptResult);
    }

}
