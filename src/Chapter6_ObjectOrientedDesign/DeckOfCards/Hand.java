package Chapter6_ObjectOrientedDesign.DeckOfCards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selimkonuk on 18/02/2018.
 */
public abstract class Hand<T extends Card> {
    protected List<T> cards = new ArrayList<T>();

    public void addCard(T card) {
        this.cards.add(card);
    }

    public void removeCard(T card) {
        this.cards.remove(card);
    }

    public abstract int score();
}
