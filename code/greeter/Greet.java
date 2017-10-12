public class Greet {

    public static void main(String[] args) {
        Greeter greeter = Greeter.create();
        System.out.println(greeter.greet());
    }
}
