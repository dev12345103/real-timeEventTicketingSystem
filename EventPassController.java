package com.eventbooking.Controller;

import com.eventbooking.Model.EventPass;
import com.eventbooking.Service.EventPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/passes")
public class EventPassController {
    @Autowired
    private EventPassService eventPassService;

    @PostMapping("/release")
    public String releasePass(@RequestBody EventPass pass) {
        return eventPassService.addPassToQueue(pass) ?
                "Pass released successfully" : "Queue is full";
    }


    @GetMapping("/available")
    public int getAvailablePasses() {
        return eventPassService.getAvailablePassCount();
    }
}

