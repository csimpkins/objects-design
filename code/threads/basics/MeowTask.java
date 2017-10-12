public class MeowTask implements Runnable {

    public void run() {
        for (int i = 0; i < 9; i++) {
            System.out.println(Thread.currentThread().getName() +": Meow ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() +
                    ":Don't stop me meow, I have " + (9 - i) + " to go!");
                return;
            }
        }
        System.out.println("Meow!");
    }
}
