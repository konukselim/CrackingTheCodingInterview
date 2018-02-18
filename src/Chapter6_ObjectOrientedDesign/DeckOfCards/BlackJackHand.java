package Chapter6_ObjectOrientedDesign.DeckOfCards;

/**
 * Created by selimkonuk on 18/02/2018.
 */
public class BlackJackHand extends Hand<BlackJackCard> {

    @Override
    public int score() {
        // score logic for BlackJackHand
        return 21;
    }

    public boolean wantMore() {
        // implement hit or stay decision
        return true;
    }

    public boolean is21() {
        // check if cards score is 21
        return true;
    }

    public int decideAceValue() {
        // decide ace value for the best score
        return 1;
    }

}
