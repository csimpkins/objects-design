public class TimeoutMeow {

    public static void main(String[] args) throws InterruptedException {
        long timeoutMillis = 2000;
        if (args.length > 0) {
            try {
                timeoutMillis = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.out.println(args[0] + " not recognized.");
            }
        }
        System.out.println("Using timeout of " + (timeoutMillis/1000) + " seconds.");
        long start = System.currentTimeMillis();
        Thread t = new Thread(new MeowTask());
        t.start();
        while (t.isAlive()) {
            // What if we don't give the thread a second to finish before checking timeout?
            t.join(1000);
            if ((System.currentTimeMillis() - start) > timeoutMillis) {
                t.interrupt();
                t.join();
            }
        }
        System.out.println("Done.");
    }
}
