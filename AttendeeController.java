package com.eventbooking.Controller;

import com.eventbooking.Service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {
    @Autowired
    private AttendeeService attendeeService;

    @PostMapping("/register")
    public String registerAttendee(@RequestParam int attendeeId) {
        attendeeService.registerAttendee(attendeeId);
        return "Registration successful";
    }
}
