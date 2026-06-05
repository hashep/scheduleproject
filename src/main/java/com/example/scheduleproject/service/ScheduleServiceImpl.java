package com.example.scheduleproject.service;

import com.example.scheduleproject.dto.ScheduleForm;
import com.example.scheduleproject.dto.ScheduleUpdateForm;
import com.example.scheduleproject.entity.Schedule;
import com.example.scheduleproject.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> index() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule show(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    @Override
    public Schedule create(ScheduleForm scheduleForm) {
        Schedule schedule = new Schedule(
                null,
                scheduleForm.getTitle(),
                scheduleForm.getContent(),
                scheduleForm.getDate(),
                scheduleForm.getLocation()
        );

        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule update(Long id, ScheduleUpdateForm scheduleUpdateForm) {
        Schedule target = scheduleRepository.findById(id).orElse(null);

        if (target == null) {
            return null;
        }

        if (scheduleUpdateForm.getTitle() != null) {
            target.setTitle(scheduleUpdateForm.getTitle());
        }

        if (scheduleUpdateForm.getContent() != null) {
            target.setContent(scheduleUpdateForm.getContent());
        }

        if (scheduleUpdateForm.getDate() != null) {
            target.setDate(scheduleUpdateForm.getDate());
        }

        if (scheduleUpdateForm.getLocation() != null) {
            target.setLocation(scheduleUpdateForm.getLocation());
        }

        return scheduleRepository.save(target);
    }

    @Override
    public Schedule delete(Long id) {
        Schedule target = scheduleRepository.findById(id).orElse(null);

        if (target == null) {
            return null;
        }

        scheduleRepository.delete(target);
        return target;
    }

    @Override
    public List<Schedule> search(String keyword) {
        return scheduleRepository.findByTitleContaining(keyword);
    }

    @Override
    public List<Schedule> findByDate(String date) {
        return scheduleRepository.findByDate(date);
    }
}