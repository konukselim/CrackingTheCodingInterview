package Chapter6_ObjectOrientedDesign.DeckOfCards;

import java.util.List;

/**
 * Created by selimkonuk on 18/02/2018.
 */
public class Deck<T extends Card> {
    private List<T> cards;
    private int numberOfCards;

    private void gatherCards(List<T> cards) {
        this.cards = cards;
        this.numberOfCards = cards.size();
    }

    public void shuffle() {
        // Implement shuffle method
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public T dealCard() {
        // Implement deal method
        return null;
    }

    public void upsideDown(int index) {
        // Implement upside down method
    }

}
