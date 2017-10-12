import java.util.Random;

public class CounterTest {

    static Random random = new Random();

    static class IncrementTask implements Runnable {

        private Counter counter;
        private int num;

        public IncrementTask(Counter counter, int num) {
            this.counter = counter;
            this.num = num;
        }

        public void run() {
            for (int i = 0; i < num; i++) {
                counter.increment();
            }
        }
    }

    static class DecrementTask implements Runnable {

        private Counter counter;
        private int num;

        public DecrementTask(Counter counter, int num) {
            this.counter = counter;
            this.num = num;
        }

        public void run() {
            for (int i = num; i > 0; i--) {
                counter.decrement();
            }
        }
    }

    private static void interferenceExperiment(Counter counter, int num)
            throws InterruptedException {
        Thread incrementer = new Thread(new IncrementTask(counter, num));
        Thread decrementer = new Thread(new DecrementTask(counter, num));
        incrementer.start();
        decrementer.start();
        incrementer.join();
        decrementer.join();
    }

    public static void main(String[] args) throws InterruptedException {
        int num = (args.length > 0) ? Integer.parseInt(args[0]) : 100;
        System.out.println("Incrementing and decrementing " + num + " times.");
        Counter unsafeCounter = new UnsafeCounter();
        interferenceExperiment(unsafeCounter, num);
        System.out.println("Unsafe counter final value: "
            + unsafeCounter.value());
        Counter synchronizedCounter = new SynchronizedCounter();
        interferenceExperiment(synchronizedCounter, num);
        System.out.println("Synchronized counter final value: "
            + synchronizedCounter.value());
    }

}
