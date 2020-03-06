package Design.BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Hand {
    protected final List<Card> cards = new ArrayList<>();
    public abstract int score();
    public void addCards(Card[] c) {
        Collections.addAll(cards, c);
    }

    public int size() {
        return cards.size();
    }
}
