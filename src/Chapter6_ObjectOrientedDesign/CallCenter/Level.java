package Chapter6_ObjectOrientedDesign.CallCenter;

/**
 * Created by selimkonuk on 18/02/2018.
 */
public enum Level {
    Respondent (0),
    Manager (1),
    Director (2);

    private int value;
    private Level(int value) {
        this.value = value;
    }
    public int getValue() { return value; }
}
