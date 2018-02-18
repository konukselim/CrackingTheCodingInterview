package Chapter6_ObjectOrientedDesign.CallCenter;

/**
 * Created by selimkonuk on 18/02/2018.
 */
public abstract class Employee {
    protected boolean isAvailable;
    protected Level level;
    private Call call;

    public Employee() {
        // ordinary employee settings
    }

    public static void notifyCallCenter() {
        // notify call center when call
        // escalated or issue resolved
    }

    public void endCall() {
        this.isAvailable = true;
        this.call = null;
        notifyCallCenter();
    }

    public void assignCall(Call call) {
        this.isAvailable = false;
        this.call = call;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Level getLevel() {
        return level;
    }

    public void escalateCall() {
        // escalate call to a higher level employee
    }
}

