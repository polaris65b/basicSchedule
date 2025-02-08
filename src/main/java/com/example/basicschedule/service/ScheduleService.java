package com.example.basicschedule.service;

import com.example.basicschedule.dto.ScheduleRequestDto;
import com.example.basicschedule.dto.ScheduleResponseDto;
import com.example.basicschedule.entity.Schedule;
import com.example.basicschedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // Create
    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(
                dto.getContent(),
                dto.getDate()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getContent(),
                savedSchedule.getDate()
        );
    }

    // Read

    // 전체 조회
    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll(){
        List<Schedule> schedules = scheduleRepository.findAll();

        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            dtos.add(new ScheduleResponseDto(
                    schedule.getId(),
                    schedule.getContent(),
                    schedule.getDate()
            ));
        }
        return dtos;
    }
    
    // 선택 조회
    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long id){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 일정이 없습니다.")
        );
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getContent(),
                schedule.getDate()
        );
    }

    // Update
    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto dto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 일정이 없습니다.")
        );
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getContent(),
                schedule.getDate()
        );
    }

    // Delete
    @Transactional
    public void delete(Long id) {
        if(!scheduleRepository.existsById(id)){
            throw new IllegalArgumentException("해당 id에 맞는 일정이 없습니다.");
        }
        scheduleRepository.deleteById(id);
    }
}
