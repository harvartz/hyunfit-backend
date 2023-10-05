package com.backend.hyunfit.domain.trnf.controller;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import com.backend.hyunfit.domain.trnf.service.TrainerFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
    public ResponseEntity<TrainerFeedbackDTO> getGptFeedback(@RequestBody MemberDTO memberDTO) {
        TrainerFeedbackDTO gptResult = trainerFeedbackService.getGptFeedback(memberDTO);
        return ResponseEntity.ok(gptResult);
    }

}
