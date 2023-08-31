package com.backend.hyunfit.domain.pt.controller;

import com.backend.hyunfit.domain.pt.dto.PtDTO;
import com.backend.hyunfit.domain.pt.service.PtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/personal-trainings")
public class PtControllerImpl implements PtController {

    private final PtService ptService;

    @Override
    @PostMapping
    public ResponseEntity<PtDTO> createPt(@RequestBody PtDTO ptDTO) {
        ptService.createPt(ptDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ptDTO);
    }

    @Override
    @PutMapping(value = "/{ptSeq}")
    public ResponseEntity<PtDTO> modifyPt(@PathVariable long ptSeq, @RequestBody PtDTO ptDTO) {
        ptDTO.setPtSeq(ptSeq);
        ptService.modifyPt(ptDTO);
        return ResponseEntity.ok(ptDTO);
    }
}
