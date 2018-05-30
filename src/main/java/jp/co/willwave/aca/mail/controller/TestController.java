package jp.co.willwave.aca.mail.controller;

import jp.co.willwave.aca.mail.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/create")
    public ResponseEntity<String> updateSchedule() {
        scheduleService.createSchedule();
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteSchedule() {
        scheduleService.deleteSchedule();
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/create2/{key}")
    public ResponseEntity<String> createSchedule2(@PathVariable("key") String key) {
        scheduleService.createSchedule2(key);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/delete2/{key}")
    public ResponseEntity<String> deleteSchedule2(@PathVariable("key") String key) {
        scheduleService.deleteSchedule2(key);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/update2/{key}")
    public ResponseEntity<String> updateSchedule2(@PathVariable("key") String key) {
        scheduleService.updateSchedule2(key);
        return ResponseEntity.ok("OK");
    }
}
