import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyTests {

    @Test
    public void isThreeOfAKind() {
        Collection<Card> cards = Stream.generate(Card::new).limit(5).collect(Collectors.toList());

        ((List<Card>) cards).get(0).setRank("3");
        ((List<Card>) cards).get(1).setRank("3");
        ((List<Card>) cards).get(2).setRank("3");
        ArrayList<String> cardRanks = Main.getCardRankList(cards);
        List<String> cardRanksDistinct = Main.getCardRankDistinct(cardRanks);


        Main.printCards(cards);
        Assert.assertTrue(Main.isThreeOfAKind(cardRanks, cardRanksDistinct));
    }

    @Test
    public void isRoyalFlashTest() {
        Collection<Card> cards = Stream.generate(Card::new).limit(5).collect(Collectors.toList());


        ((List<Card>) cards).get(0).setRank("10");
        ((List<Card>) cards).get(1).setRank("Jack");
        ((List<Card>) cards).get(2).setRank("Queen");
        ((List<Card>) cards).get(3).setRank("King");
        ((List<Card>) cards).get(4).setRank("Ace");

        ((List<Card>) cards).get(0).setSuit("hearts");
        ((List<Card>) cards).get(1).setSuit("hearts");
        ((List<Card>) cards).get(2).setSuit("hearts");
        ((List<Card>) cards).get(3).setSuit("hearts");
        ((List<Card>) cards).get(4).setSuit("hearts");

        ((List<Card>) cards).get(0).setColor("red");
        ((List<Card>) cards).get(1).setColor("red");
        ((List<Card>) cards).get(2).setColor("red");
        ((List<Card>) cards).get(3).setColor("red");
        ((List<Card>) cards).get(4).setColor("red");
        ArrayList<String> cardRanks = Main.getCardRankList(cards);
        HashSet<String> cardSuits = Main.getCardSuitList(cards);

        Main.printCards(cards);
        Assert.assertTrue(Main.isRoyalFlash(cardRanks, cardSuits));
    }

    @Test
    public void isStraightFlashTest() {
        Collection<Card> cards = Stream.generate(Card::new).limit(5).collect(Collectors.toList());
        ((List<Card>) cards).get(0).setRank("7");
        ((List<Card>) cards).get(1).setRank("8");
        ((List<Card>) cards).get(2).setRank("9");
        ((List<Card>) cards).get(3).setRank("10");
        ((List<Card>) cards).get(4).setRank("Jack");

        ((List<Card>) cards).get(0).setSuit("hearts");
        ((List<Card>) cards).get(1).setSuit("hearts");
        ((List<Card>) cards).get(2).setSuit("hearts");
        ((List<Card>) cards).get(3).setSuit("hearts");
        ((List<Card>) cards).get(4).setSuit("hearts");

        ((List<Card>) cards).get(0).setColor("red");
        ((List<Card>) cards).get(1).setColor("red");
        ((List<Card>) cards).get(2).setColor("red");
        ((List<Card>) cards).get(3).setColor("red");
        ((List<Card>) cards).get(4).setColor("red");

        ArrayList<String> cardRanks = Main.getCardRankList(cards);
        HashSet<String> cardSuits = Main.getCardSuitList(cards);

        Main.printCards(cards);
        Assert.assertTrue(Main.isStraightFlash(cardRanks, cardSuits));
    }

    @Test
    public void isFourOfAKindTest() {
        Collection<Card> cards = Stream.generate(Card::new).limit(5).collect(Collectors.toList());
        ((List<Card>) cards).get(0).setRank("4");
        ((List<Card>) cards).get(1).setRank("4");
        ((List<Card>) cards).get(2).setRank("4");
        ((List<Card>) cards).get(3).setRank("4");
        ((List<Card>) cards).get(4).setRank("Jack");

        ArrayList<String> cardRanks = Main.getCardRankList(cards);
        Main.printCards(cards);
        Assert.assertTrue(Main.isFourOfAKind(cardRanks));
    }

    @Test
    public void isFullHouseTest() {
        Collection<Card> cards = Stream.generate(Card::new).limit(5).collect(Collectors.toList());
        ((List<Card>) cards).get(0).setRank("4");
        ((List<Card>) cards).get(1).setRank("4");
        ((List<Card>) cards).get(2).setRank("4");
        ((List<Card>) cards).get(3).setRank("10");
        ((List<Card>) cards).get(4).setRank("10");

        ArrayList<String> cardRanks = Main.getCardRankList(cards);
        List<String> cardRanksDistinct = Main.getCardRankDistinct(cardRanks);

        Main.printCards(cards);
        Assert.assertTrue(Main.isFullHouse(cardRanks, cardRanksDistinct));
    }

    @Test
    public void isFlushTest() {
        Collection<Card> cards = Stream.generate(Card::new).limit(5).collect(Collectors.toList());
        ((List<Card>) cards).get(0).setSuit("hearts");
        ((List<Card>) cards).get(1).setSuit("hearts");
        ((List<Card>) cards).get(2).setSuit("hearts");
        ((List<Card>) cards).get(3).setSuit("hearts");
        ((List<Card>) cards).get(4).setSuit("hearts");

        ((List<Card>) cards).get(0).setRank("10");
        ((List<Card>) cards).get(1).setRank("2");
        ((List<Card>) cards).get(2).setRank("3");
        ((List<Card>) cards).get(3).setRank("4");
        ((List<Card>) cards).get(4).setRank("5");

        ArrayList<String> cardRanks = Main.getCardRankList(cards);
        HashSet<String> cardSuits = Main.getCardSuitList(cards);

        Main.printCards(cards);
        Assert.assertTrue(Main.isFlush(cardRanks, cardSuits));
    }

    @Test
    public void isTwoPairTest() {
        Collection<Card> cards = Stream.generate(Card::new).limit(5).collect(Collectors.toList());
        ((List<Card>) cards).get(0).setRank("8");
        ((List<Card>) cards).get(1).setRank("8");
        ((List<Card>) cards).get(2).setRank("7");
        ((List<Card>) cards).get(3).setRank("7");
        ((List<Card>) cards).get(4).setRank("2");

        ArrayList<String> cardRanks = Main.getCardRankList(cards);

        Main.printCards(cards);
        Assert.assertTrue(Main.isTwoPair(cardRanks));
    }

    @Test
    public void isStraight() {
        Collection<Card> cards = Stream.generate(Card::new).limit(5).collect(Collectors.toList());
        ((List<Card>) cards).get(0).setRank("2");
        ((List<Card>) cards).get(1).setRank("3");
        ((List<Card>) cards).get(2).setRank("4");
        ((List<Card>) cards).get(3).setRank("5");
        ((List<Card>) cards).get(4).setRank("6");

        ArrayList<String> cardRanks = Main.getCardRankList(cards);
        HashSet<String> cardSuits = Main.getCardSuitList(cards);

        Main.printCards(cards);
        Assert.assertTrue(Main.isStraight(cardRanks, cardSuits));
    }

    @Test
    public void isStraight2() {
        Collection<Card> cards = Stream.generate(Card::new).limit(5).collect(Collectors.toList());
        ((List<Card>) cards).get(0).setRank("7");
        ((List<Card>) cards).get(1).setRank("8");
        ((List<Card>) cards).get(2).setRank("9");
        ((List<Card>) cards).get(3).setRank("10");
        ((List<Card>) cards).get(4).setRank("Jack");

        ArrayList<String> cardRanks = Main.getCardRankList(cards);
        HashSet<String> cardSuits = Main.getCardSuitList(cards);

        Main.printCards(cards);
        Assert.assertTrue(Main.isStraight(cardRanks, cardSuits));
    }

    @Test
    public void isStraight3() {
        Collection<Card> cards = Stream.generate(Card::new).limit(5).collect(Collectors.toList());
        ((List<Card>) cards).get(0).setRank("8");
        ((List<Card>) cards).get(1).setRank("9");
        ((List<Card>) cards).get(2).setRank("10");
        ((List<Card>) cards).get(3).setRank("Jack");
        ((List<Card>) cards).get(4).setRank("Queen");

        ArrayList<String> cardRanks = Main.getCardRankList(cards);
        HashSet<String> cardSuits = Main.getCardSuitList(cards);

        Main.printCards(cards);
        Assert.assertFalse(Main.isStraight(cardRanks, cardSuits));
    }

    @Test
    public void isPairTest() {
        Collection<Card> cards = Stream.generate(Card::new).limit(5).collect(Collectors.toList());
        ((List<Card>) cards).get(0).setRank("8");
        ((List<Card>) cards).get(1).setRank("9");
        ((List<Card>) cards).get(2).setRank("7");
        ((List<Card>) cards).get(3).setRank("7");
        ((List<Card>) cards).get(4).setRank("2");

        ArrayList<String> cardRanks = Main.getCardRankList(cards);

        Main.printCards(cards);
        Assert.assertTrue(Main.isPair(cardRanks));
    }

    @Test
    public void getHighCardTest() {
        Collection<Card> cards = Stream.generate(Card::new).limit(5).collect(Collectors.toList());
        ((List<Card>) cards).get(0).setRank("8");
        ((List<Card>) cards).get(1).setRank("9");
        ((List<Card>) cards).get(2).setRank("7");
        ((List<Card>) cards).get(3).setRank("7");
        ((List<Card>) cards).get(4).setRank("10");

        ArrayList<String> cardRanks = Main.getCardRankList(cards);

        Main.printCards(cards);
        String highCard = Main.findHighCard(cardRanks);
        Assert.assertEquals("High Card is: "  + "10", highCard);
    }

    @Test
    public void getHighCardTest2() {
        Collection<Card> cards = Stream.generate(Card::new).limit(5).collect(Collectors.toList());
        ((List<Card>) cards).get(0).setRank("10");
        ((List<Card>) cards).get(1).setRank("9");
        ((List<Card>) cards).get(2).setRank("7");
        ((List<Card>) cards).get(3).setRank("Jack");
        ((List<Card>) cards).get(4).setRank("King");

        ArrayList<String> cardRanks = Main.getCardRankList(cards);

        Main.printCards(cards);
        String highCard = Main.findHighCard(cardRanks);
        Assert.assertEquals("High Card is: " + "King", highCard);
    }

}
