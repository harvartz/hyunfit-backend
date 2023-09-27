package com.backend.hyunfit.domain.trnf.service;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import com.backend.hyunfit.domain.trnf.mapper.TrainerFeedbackMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TrainerFeedbackServiceImpl implements TrainerFeedbackService{

    private final TrainerFeedbackMapper trainerFeedbackMapper;
    @Value("${ai-url}")
    private String aiUrl;
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
        String fastApiUrl = aiUrl + "/generate_fitness_report/";

        // HttpHeaders 객체 생성 및 Content-Type 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // HttpEntity 객체 생성
        HttpEntity<MemberDTO> entity = new HttpEntity<>(memberDTO, headers);

        System.out.println(entity);
        System.out.println("이다음이 중요합니다!!!!");

        // 이 부분에서 HttpEntity 객체를 사용해서 요청을 전송
        ResponseEntity<Map> response = restTemplate.postForEntity(fastApiUrl, entity, Map.class);
        System.out.println("++++++++++++++++++++response"+response);

        // 이 부분은 기존 코드와 동일
        String aiMessage = response.getBody().get("ai_message").toString();

        TrainerFeedbackDTO trainerFeedbackDTO = new TrainerFeedbackDTO();
        trainerFeedbackDTO.setContent(aiMessage);

        return trainerFeedbackDTO;
    }
}
