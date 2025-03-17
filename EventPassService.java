package com.eventbooking.Service;

import com.eventbooking.Model.EventPass;
import com.eventbooking.Model.PassQueue;
import org.springframework.stereotype.Service;

@Service
public class EventPassService {
    private final PassQueue passQueue = new PassQueue(50);

    public boolean addPassToQueue(EventPass pass) {
        return passQueue.addPass(pass);
    }

    public EventPass retrievePassFromQueue() {
        return passQueue.retrievePass();
    }

    public int getAvailablePassCount() {
        return passQueue.getAvailableSpace();
    }
}
