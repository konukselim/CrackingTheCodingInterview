package Chapter6_ObjectOrientedDesign.CallCenter;

/**
 * Created by selimkonuk on 18/02/2018.
 */
public class Manager extends Employee {
    public Manager() {
        super();
        level = Level.Manager;
    }

    public boolean isFree() {
        // check if manager is free to handle
        // to call.
        return true;
    }
}
