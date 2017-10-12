public class BasicMeow {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MeowTask(), "Foster");
        t.start();
        // What if we don't join?
        t.join();
        System.out.println("Done.");
    }
}
