package com.luv2code.task2;

class RingBuffer {
    private final String[] buffer;
    private final int capacity;

    private int head = 0;
    private int tail = 0;
    private int count = 0;

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new String[capacity];
    }

    public synchronized void put(String message) {
        while (count == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        buffer[tail] = message;
        tail = (tail + 1) % capacity;
        count++;

        notifyAll();
    }

    public synchronized String take() {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }

        String message = buffer[head];
        head = (head + 1) % capacity;
        count--;

        notifyAll();

        return message;
    }
}
