public class Foster implements Runnable {
    private Larry larry;

    String[] dialog = {
        "All right meow. Hand over your license and registration.", // 1
        "Your registration? Hurry up meow.", // 2
        "Is there something funny here boy?",
        "Then why you laughing, Mister… Larry Johnson?",
        "All right meow, where were we?", // 3
        "Am I saying m-e-o-w?", // 3 -- doesn't count
        "Don’t think boy. Meow, do you know how fast you were going?", // 4
        "Meow. What is so damn funny?",  // 5
        "Do I look like a cat to you, boy?",
        "Am I jumpin’ around all nimbly bimbly from tree to tree?",
        "Am I drinking milk from a saucer?",
        "Do you see me eating mice?",
        "You stop laughing right meow!", // 6
        "Meow, I’m gonna have to give you a ticket on this one.", // 7
        "No buts meow. It’s the law.",  // 8
        "Not so funny meow, is it?",  // 9
        "Meow!" // 10
    };

    public Foster(Larry larry) {
        this.larry = larry;
    }

    public void run() {
        for (String line: dialog) {
            larry.say(line);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
        }
    }
}
