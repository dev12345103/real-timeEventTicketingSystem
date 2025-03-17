package com.eventbooking.Model;

import lombok.Data;

@Data
public class SettingsDTO {
    private int eventCapacity;
    private int releaseInterval;
    private int processingRate;
    private int maxQueueSize;



}
