package co.com.sofka.calendar.controllers;

import co.com.sofka.calendar.model.ProgramDate;
import co.com.sofka.calendar.services.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@RestController
public class ProgramController {
    @Autowired
    private SchedulerService schedulerService;

    @GetMapping(value = "/{id}")
    public Flux<ProgramDate> get(@PathVariable("id") String id){
        var startDate = LocalDate.of(2022, 1, 1);
        return schedulerService.generateCalendar(id,startDate);
    }
}