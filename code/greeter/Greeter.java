import java.io.FileInputStream;
import java.util.Properties;

/**
 * Plays the roles of ConcreteCreator and (abstract) Product in the
 * Factory Method design pattern (GoF 107).
 */
public abstract class Greeter {

    /**
     * Note that in this simple application, the properties object is only
     * used in this class.  If you wanted a properties object that other classes
     * could use, you'd want to create another object (like a Config object)
     * that other classes could get a reference to.
     */
    private static Properties props;

    static {
        props = new Properties();
        try {
            props.load(new FileInputStream("greeter.properties"));
        } catch (Exception e) {
            props.put("greeterClass", "EnglishGreeter");
        }
    }

    /**
     * The only method subclasses need to implement.
     */
    public abstract String greet();

    /**
     * Factory method using greeterClass property from greeter.properties,
     * or EnglishGreeter as default.
     */
    public static Greeter create() {
        String greeterClassName = props.getProperty("greeterClass");
        Greeter greeter = new EnglishGreeter();
        try {
            greeter = (Greeter) Class.forName(greeterClassName).newInstance();
        } catch(Exception e) {
            System.out.println("Coudln't load " + greeterClassName +
                ". Using EnglishGreeter.");
        }
        return greeter;
    }
}
