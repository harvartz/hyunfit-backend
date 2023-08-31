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
    public ResponseEntity<PersonalTrainingDTO> createPt(@RequestBody PersonalTrainingDTO ptDTO) {
        personalTrainingService.createPt(ptDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ptDTO);
    }

    @Override
    @PutMapping(value = "/{ptSeq}")
    public ResponseEntity<PersonalTrainingDTO> modifyPt(@PathVariable long ptSeq, @RequestBody PersonalTrainingDTO ptDTO) {
        ptDTO.setPtSeq(ptSeq);
        personalTrainingService.modifyPt(ptDTO);
        return ResponseEntity.ok(ptDTO);
    }

    @Override
    @PostMapping(value = "/{ptSeq}/review")
    public ResponseEntity<PersonalTrainingDTO> createPtReview(long ptSeq, @RequestBody PersonalTrainingDTO ptDTO) {
        ptDTO.setPtSeq(ptSeq);
        personalTrainingService.createPtReview(ptDTO);
        return ResponseEntity.ok(ptDTO);
    }
}
