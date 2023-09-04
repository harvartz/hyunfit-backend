package com.backend.hyunfit.domain.trnf.service;

import com.backend.hyunfit.domain.trn.dto.FeedbackDTO;
import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import com.backend.hyunfit.domain.trnf.mapper.TrainerFeedbackMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.Timestamp;
import java.time.Instant;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TrainerFeedbackServiceImpl implements TrainerFeedbackService{

    private final TrainerFeedbackMapper trainerFeedbackMapper;

    @Override
    public TrainerFeedbackDTO insertFeedback(TrainerFeedbackDTO feedbackDTO) {
        trainerFeedbackMapper.insertFeedback(feedbackDTO);
        return feedbackDTO;
    }

    @Override
    public TrainerFeedbackDTO getGptFeedback(String content) {

        RestTemplate restTemplate = new RestTemplate();
        String fastApiUrl = "http://127.0.0.1:8000/generate-fitness-report/";

        TrainerFeedbackDTO requestData = new TrainerFeedbackDTO();
        requestData.setContent(content);

        ResponseEntity<Map> response = restTemplate.postForEntity(fastApiUrl, requestData, Map.class);
        String aiMessage = response.getBody().get("ai_message").toString();
        
        TrainerFeedbackDTO trainerFeedbackDTO = new TrainerFeedbackDTO();
        trainerFeedbackDTO.setContent(aiMessage);

        return trainerFeedbackDTO;
    }
}
