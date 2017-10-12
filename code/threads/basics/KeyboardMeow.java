import java.util.Scanner;

public class KeyboardMeow {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MeowTask());
        t.start();
        System.out.println("Press q to quit.");
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        while (t.isAlive() && !input.equalsIgnoreCase("q")) {
            // What if user doesn't enter anything?
            input = keyboard.next();
            if (input.equalsIgnoreCase("q")) {
                t.interrupt();
                // What if we don't join?
                t.join();
            }
        }
        System.out.println("Done.");
    }
}
