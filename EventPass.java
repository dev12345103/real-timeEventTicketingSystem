package com.eventbooking.Model;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class EventPass {
    private String passId;
    private int sequenceNumber;
}
