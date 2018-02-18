package Chapter6_ObjectOrientedDesign.DeckOfCards;

/**
 * Created by selimkonuk on 18/02/2018.
 */
public abstract class Card {
    protected House house;
    protected int value;
    private boolean available;

    public Card (House house, int value, boolean available) {
        this.house = house;
        this.value = value;
        this.available = available;
    }

    /**
     * Specific class that extends "Card" could have different values.
     * Different classes will have different values, so child class
     * should implement it's own value method for it's cards.
     * @return
     */
    public abstract int value();

    public House house() { return this.house; }
    public boolean isAvailable() { return this.available; }
    public void markAvailable() { this.available = true; }
    public void markUnavailable() { this.available = false; }

}
