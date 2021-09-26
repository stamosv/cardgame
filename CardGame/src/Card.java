import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Card {

    private Random generator = new Random();
    private String suit, rank, color;

    static String[] suits = {"hearts", "spades", "diamonds", "clubs"};
    static String[] ranks = {"2", "3", "4", "5", "6", "7", "8",
            "9", "10", "Jack", "Queen", "King", "Ace"};

    int randomSuits = generator.nextInt(suits.length);
    int randomRanks = generator.nextInt(ranks.length);

    public Card() {
        suit = suits[randomSuits];
        rank = ranks[randomRanks];
        if (suit.equals("hearts") || suit.equals("diamonds")) {
            color = "red";
        } else {
            color = "black";
        }

    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String[] getSuits() {
        return suits;
    }

    public void setSuits(String[] suits) {
        this.suits = suits;
    }

    public String[] getRanks() {
        return ranks;
    }

    public void setRanks(String[] ranks) {
        this.ranks = ranks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return randomSuits == card.randomSuits &&
                randomRanks == card.randomRanks &&
                Objects.equals(suit, card.suit) &&
                Objects.equals(rank, card.rank) &&
                Objects.equals(color, card.color) &&
                Objects.equals(generator, card.generator) &&
                Arrays.equals(suits, card.suits) &&
                Arrays.equals(ranks, card.ranks);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(suit, rank, color, generator, randomSuits, randomRanks);
        result = 31 * result + Arrays.hashCode(suits);
        result = 31 * result + Arrays.hashCode(ranks);
        return result;
    }
}