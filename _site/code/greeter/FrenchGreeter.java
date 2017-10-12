/**
 * This class plays the role of a ConcreteProduct in the Factory Method pattern.
 * (GoF 107)
 */
 public class FrenchGreeter extends Greeter {

    public String greet() {
        return "Bonjour!";
    }
}
