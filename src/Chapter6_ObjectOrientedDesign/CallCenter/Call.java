package Chapter6_ObjectOrientedDesign.CallCenter;

/**
 * Created by selimkonuk on 18/02/2018.
 */
public class Call {
    private Caller caller;
    private Level level;
    private Employee handler;

    public Call(Caller caller) {
        this.caller = caller;
        this.level = Level.Respondent;
    }

    public void setHandler(Employee employee) {
        this.handler = employee;
    }

    public Level getLevel() {
        return level;
    }

    public void levelUp() {
        if (level == Level.Respondent)
            level = Level.Manager;
        else if (level == Level.Manager)
            level = Level.Director;
    }
}
