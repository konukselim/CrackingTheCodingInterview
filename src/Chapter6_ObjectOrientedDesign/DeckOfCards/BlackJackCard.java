package Chapter6_ObjectOrientedDesign.DeckOfCards;

/**
 * Created by selimkonuk on 18/02/2018.
 */
public class BlackJackCard extends Card {

    public BlackJackCard(House h, int value, boolean available) {
        super(h, value, available);
    }

    @Override
    public int value() {
        if (isAce()) {
            return 1;
        }
        if (isFace()) {
            return 10;
        }
        return value;
    }

    public int getMaxAce() {
        return 11;
    }

    public boolean isAce() {
        return value == 1;
    }

    /**
     * Checks if card is a face card. In blackjack there
     * is no difference between the faces. If there exist
     * a difference in game between faces, there could be
     * different implementation of each of them.
     */
    public boolean isFace() {
        return (value >= 11 && value <= 13);
    }
}
