package com.example.scheduleproject.service;

import com.example.scheduleproject.dto.ScheduleForm;
import com.example.scheduleproject.dto.ScheduleUpdateForm;
import com.example.scheduleproject.entity.Schedule;

import java.util.List;

public interface ScheduleService {

    List<Schedule> index();

    Schedule show(Long id);

    Schedule create(ScheduleForm scheduleForm);

    Schedule update(Long id, ScheduleUpdateForm scheduleUpdateForm);

    Schedule delete(Long id);

    List<Schedule> search(String keyword);

    List<Schedule> findByDate(String date);
}