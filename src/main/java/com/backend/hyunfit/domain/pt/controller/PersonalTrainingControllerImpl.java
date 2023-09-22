package com.backend.hyunfit.domain.pt.controller;

import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import com.backend.hyunfit.domain.pt.service.PersonalTrainingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/personal-trainings")
public class PersonalTrainingControllerImpl implements PersonalTrainingController {

    private final PersonalTrainingService personalTrainingService;

    @Override
    @PostMapping
    public ResponseEntity<PersonalTrainingDTO> createPt(@RequestBody PersonalTrainingDTO personalTrainingDTO) {
        personalTrainingService.createPt(personalTrainingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(personalTrainingDTO);
    }

    @Override
    @PutMapping(value = "/{ptSeq}")
    public ResponseEntity<PersonalTrainingDTO> modifyPt(@PathVariable long ptSeq, @RequestBody PersonalTrainingDTO personalTrainingDTO) {
        personalTrainingDTO.setPtSeq(ptSeq);
        personalTrainingService.modifyPt(personalTrainingDTO);
        return ResponseEntity.ok(personalTrainingDTO);
    }

    @Override
    @PostMapping(value = "/{ptSeq}/review")
    public ResponseEntity<PersonalTrainingDTO> createPtReview(long ptSeq, @RequestBody PersonalTrainingDTO personalTrainingDTO) {
        personalTrainingDTO.setPtSeq(ptSeq);
        personalTrainingService.createPtReview(personalTrainingDTO);
        log.info("리뷰 등록 완료");
        return ResponseEntity.ok(personalTrainingDTO);
    }


    @Override
    @GetMapping("/{ptSeq}")
    public ResponseEntity<PersonalTrainingDTO> selectOnePtByPtrSeq(@PathVariable long ptSeq) {
        PersonalTrainingDTO personalTrainingDTO = personalTrainingService.selectOnePtByPtSeq(ptSeq);
        return ResponseEntity.status(HttpStatus.OK).body(personalTrainingDTO);
    }
}
