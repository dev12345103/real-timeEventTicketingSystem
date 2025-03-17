package com.eventbooking.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class SystemSettings {
    private int eventCapacity;
    private int releaseInterval;
    private int processingRate;
    private int maxQueueSize;

    public SystemSettings(int eventCapacity, int releaseInterval, int processingRate, int maxQueueSize){
        this.eventCapacity = eventCapacity;
        this.releaseInterval = releaseInterval;
        this.processingRate = processingRate;
        this.maxQueueSize = maxQueueSize;
    }


}

