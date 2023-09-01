package com.backend.hyunfit.domain.rtn.controller;

import com.backend.hyunfit.domain.rtn.dto.RoutineDTO;
import com.backend.hyunfit.domain.rtn.service.RoutineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/routines")
public class RoutineControllerImpl implements RoutineController {
    private final RoutineService routineService;

    @Override
    @GetMapping("")
    public ResponseEntity<List<RoutineDTO>> selectAllRoutineFilteredSearch(RoutineDTO routineDTO) {
        List<RoutineDTO> routines = routineService.selectAllRoutineFilteredSearch(routineDTO);
        return ResponseEntity.ok(routines);
    }
}
