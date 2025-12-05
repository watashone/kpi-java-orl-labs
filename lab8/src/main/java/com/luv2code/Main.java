package com.luv2code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    private static final long TOTAL_ITERATIONS = 1_000_000_000L;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int numThreads = 1;
        if (args.length > 0) {
            try {
                numThreads = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Аргумент має бути цілим числом. Використовується 1 потік.");
            }
        } else {
            System.out.println("Кількість потоків не вказана. Використовується 1 потік.");
        }

        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Long>> results = new ArrayList<>();

        long iterationsPerThread = TOTAL_ITERATIONS / numThreads;

        for (int i = 0; i < numThreads; i++) {
            long actualIterations = (i == numThreads - 1)
                    ? iterationsPerThread + (TOTAL_ITERATIONS % numThreads)
                    : iterationsPerThread;

            MonteCarloTask task = new MonteCarloTask(actualIterations);
            results.add(executor.submit(task));
        }

        long totalInCircle = 0;
        for (Future<Long> result : results) {
            totalInCircle += result.get();
        }

        executor.shutdown();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        double piEstimate = 4.0 * totalInCircle / TOTAL_ITERATIONS;

        System.out.printf("PI is %.5f%n", piEstimate);
        System.out.printf("THREADS %d%n", numThreads);
        System.out.printf("ITERATIONS %,d%n", TOTAL_ITERATIONS);
        System.out.printf("TIME %dms%n", duration);
    }

    static class MonteCarloTask implements Callable<Long> {
        private final long iterations;

        public MonteCarloTask(long iterations) {
            this.iterations = iterations;
        }

        @Override
        public Long call() {
            long inCircleCount = 0;
            ThreadLocalRandom random = ThreadLocalRandom.current();

            for (long i = 0; i < iterations; i++) {
                double x = random.nextDouble();
                double y = random.nextDouble();

                if (x * x + y * y <= 1.0) {
                    inCircleCount++;
                }
            }
            return inCircleCount;
        }
    }
}