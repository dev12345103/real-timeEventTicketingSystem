package com.eventbooking.Model;

import lombok.Data;
import java.util.LinkedList;
import java.util.Queue;

@Data
public class PassQueue {
    private final Queue<EventPass> queue = new LinkedList<>();
    private final int capacity;

    public PassQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized boolean addPass(EventPass pass) {
        if (queue.size() >= capacity) {
            return false;
        }
        return queue.offer(pass);
    }

    public synchronized EventPass retrievePass() {
        return queue.poll();
    }

    public synchronized int getAvailableSpace() {
        return capacity - queue.size();
    }
}
