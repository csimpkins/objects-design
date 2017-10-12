/**
 * This class plays the role of a ConcreteProduct in the Factory Method pattern.
 * (GoF 107)
 */
 public class GermanGreeter extends Greeter {
    public String greet() {
        return "Guten Tag!";
    }
}
