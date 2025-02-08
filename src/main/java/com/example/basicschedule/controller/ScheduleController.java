package com.example.basicschedule.controller;

import com.example.basicschedule.dto.ScheduleRequestDto;
import com.example.basicschedule.dto.ScheduleResponseDto;
import com.example.basicschedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    // Create
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto dto){
        return ResponseEntity.ok(scheduleService.save(dto));
    }
    // Reade
    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        return ResponseEntity.ok(scheduleService.findAll());
    }
    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(scheduleService.findById(id));
    }

    // Update
    @PutMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> update(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto dto
    ){
        return ResponseEntity.ok(scheduleService.update(id, dto));
    }

    // Delete
    @DeleteMapping("/schedules/{id}")
    public void delete(@PathVariable Long id){
        scheduleService.delete(id);
    }
}
