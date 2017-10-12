public class Mac implements Runnable {
    private Larry larry;

    public Mac(Larry larry) {
        this.larry = larry;
    }

    public void run() {
        int count = 0;
        String message = larry.hear("Starting now.");
        while (count < 10) {
            if (message.toUpperCase().contains("MEOW")) {
                count++;
                if (count == 10) {
                    larry.say("That's 10!");
                } else {
                    message = larry.hear(": That's " + count);
                }
            } else {
                message = larry.hear("Waiting...");
            }
        }
    }
}
