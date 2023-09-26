package com.backend.hyunfit.domain.trnf.service;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import com.backend.hyunfit.domain.trnf.mapper.TrainerFeedbackMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public TrainerFeedbackDTO updateFeedback(TrainerFeedbackDTO feedbackDTO){
        trainerFeedbackMapper.updateFeedback(feedbackDTO);
        return feedbackDTO;
    }
    @Override
    public TrainerFeedbackDTO getGptFeedback(MemberDTO memberDTO) {

        RestTemplate restTemplate = new RestTemplate();
        String fastApiUrl = "http://127.0.0.1:8000/generate-fitness-report/";

        MemberDTO requestData = new MemberDTO();
        //requestData.setContent(memberDTO);

        ResponseEntity<Map> response = restTemplate.postForEntity(fastApiUrl, requestData, Map.class);
        String aiMessage = response.getBody().get("ai_message").toString();
        
        TrainerFeedbackDTO trainerFeedbackDTO = new TrainerFeedbackDTO();
        trainerFeedbackDTO.setContent(aiMessage);

        return trainerFeedbackDTO;
    }
}
