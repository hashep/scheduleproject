package com.example.scheduleproject.controller;

import com.example.scheduleproject.dto.ScheduleForm;
import com.example.scheduleproject.dto.ScheduleUpdateForm;
import com.example.scheduleproject.entity.Schedule;
import com.example.scheduleproject.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleApiController {

    private final ScheduleService scheduleService;

    public ScheduleApiController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<Schedule> index() {
        return scheduleService.index();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> show(@PathVariable Long id) {
        Schedule schedule = scheduleService.show(id);

        if (schedule == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(schedule);
    }

    @PostMapping
    public Schedule create(@RequestBody ScheduleForm scheduleForm) {
        return scheduleService.create(scheduleForm);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Schedule> update(
            @PathVariable Long id,
            @RequestBody ScheduleUpdateForm scheduleUpdateForm
    ) {
        Schedule updated = scheduleService.update(id, scheduleUpdateForm);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Schedule> delete(@PathVariable Long id) {
        Schedule deleted = scheduleService.delete(id);

        if (deleted == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(deleted);
    }

    @GetMapping("/search")
    public List<Schedule> search(@RequestParam String keyword) {
        return scheduleService.search(keyword);
    }

    @GetMapping("/date/{date}")
    public List<Schedule> findByDate(@PathVariable String date) {
        return scheduleService.findByDate(date);
    }
}