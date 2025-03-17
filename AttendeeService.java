package com.eventbooking.Service;

import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class AttendeeService {
    private final Set<Integer> registeredAttendees = new HashSet<>();

    public void registerAttendee(int attendeeId) {
        registeredAttendees.add(attendeeId);
    }
}
