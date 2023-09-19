package com.backend.hyunfit.domain.trn.controller;

import com.backend.hyunfit.domain.auth.dto.AuthDTO;
import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import com.backend.hyunfit.domain.trn.dto.TrainerDTO;
import com.backend.hyunfit.domain.trn.service.TrainerService;
import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import com.backend.hyunfit.global.security.provider.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "${vue.url}")
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/trainers")
public class TrainerControllerImpl implements TrainerController {
    private final TrainerService trainerService;
    private final JwtProvider jwtProvider;
    @GetMapping("/me")
    public TrainerDTO selectOneTrainerByToken(@RequestHeader("authorization") String authorizationHeader){
        AuthDTO authDTO = jwtProvider.getUserInfo(authorizationHeader);
        return trainerService.selectOneTrnByTrnId(authDTO.getUsername());
    }
    @GetMapping("{trnSeq}/personal-training")
    @Override
    public ResponseEntity<List<PersonalTrainingDTO>> findAllPtBytrnSeq(@PathVariable String trnSeq){
        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO = trainerService.selectAllPtBytrnSeq(trnSeq);
        List<PersonalTrainingDTO> ptList = trainerDTO.getPtList();
        return ResponseEntity.ok(ptList);
    }

    @GetMapping("{trnSeq}/nofeedback")
    @Override
    public ResponseEntity<List<TrainerFeedbackDTO>> findNoFeedbackBytrnSeq(@PathVariable String trnSeq){
        TrainerDTO trainerDTO = trainerService.selectNoFeedbackBytrnSeq(trnSeq);
        List<TrainerFeedbackDTO> nfbList = trainerDTO.getNoFeedbackList();
        return ResponseEntity.ok(nfbList);
    }

    @GetMapping("/{trnId}")
    @Override
    public ResponseEntity<TrainerDTO> selectOneTrnByTrnId(@PathVariable String trnId) {
        TrainerDTO trainerDTO = trainerService.selectOneTrnByTrnId(trnId);
        return ResponseEntity.ok(trainerDTO);
    }
}
