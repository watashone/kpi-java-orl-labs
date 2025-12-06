package com.luv2code.task2;

public class ProducerConsumerTask {
    public static void main(String[] args) {
        RingBuffer buffer1 = new RingBuffer(10);
        RingBuffer buffer2 = new RingBuffer(10);

        for (int i = 1; i <= 5; i++) {
            final int threadNum = i;
            Thread producer = new Thread(() -> {
                int msgCount = 0;
                while (true) {
                    try {
                        String msg = "Потік № " + threadNum + " згенерував повідомлення " + (++msgCount);
                        buffer1.put(msg);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
            producer.setDaemon(true); // Потік-демон
            producer.start();
        }

        for (int i = 1; i <= 2; i++) {
            final int threadNum = i;
            Thread middleman = new Thread(() -> {
                while (true) {
                    try {
                        String received = buffer1.take();
                        if (received != null) {
                            String newMsg = "Потік № " + threadNum + " переклав повідомлення: [" + received + "]";
                            buffer2.put(newMsg);
                        }
                    } catch (Exception e) {
                        break;
                    }
                }
            });
            middleman.setDaemon(true);
            middleman.start();
        }

        System.out.println("--- Початок читання повідомлень ---");
        for (int i = 0; i < 100; i++) {
            String finalMessage = buffer2.take();
            System.out.println((i + 1) + ". Отримано: " + finalMessage);
        }

        System.out.println("--- Програма завершила роботу (100 повідомлень отримано) ---");
    }
}
