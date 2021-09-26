import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: Vasileios Stamos
 */
public class Main {

    static List<String> royalFlushList = Arrays.asList("10", "Jack", "Queen", "King", "Ace");
    static List<String> straightFlushList = Arrays.asList("7", "8", "9", "10", "Jack");

    public static void main(String[] args) {
        try {
            Collection<Card> cards = Stream.generate(Card::new).limit(5).collect(Collectors.toList());
            ArrayList<String> cardRanks = getCardRankList(cards);
            List<String> cardRanksDistinct = getCardRankDistinct(cardRanks);
            HashSet<String> cardSuits = getCardSuitList(cards);

            printCards(cards);

            String combinationResult = combinationResult(cardRanks, cardSuits, cardRanksDistinct);
            System.out.println("The combination is: " + combinationResult);
        } catch (Exception e) {
            System.out.println("Exception occurred in main: " + e);

        }

    }

    public static Integer findBiggestDecimal(ArrayList<String> cardRanks) {
        List<Integer> integerCardsRanks = cardRanks.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        Integer max = integerCardsRanks
                .stream()
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);
        return max;
    }

    public static void printCards(Collection<Card> cards) {
        for (Card card : cards) {
            System.out.println(card.getColor() + " - " + card.getSuit() + " - " + card.getRank());
        }
    }

    public static ArrayList<String> getCardRankList(Collection<Card> cards) {
        ArrayList<String> cardRanks = new ArrayList<>();
        for (Card card : cards) {
            cardRanks.add(card.getRank());
        }
        return cardRanks;
    }

    public static ArrayList<String> getCardRankDistinct(ArrayList<String> cardRanks) {
        List<String> cardRanksDistinct = cardRanks.stream()
                .distinct()
                .collect(Collectors.toList());

        return (ArrayList<String>) cardRanksDistinct;

    }

    public static HashSet<String> getCardSuitList(Collection<Card> cards) {
        HashSet<String> cardSuits = new HashSet<>();
        for (Card card : cards) {
            cardSuits.add(card.getSuit());
        }
        return cardSuits;
    }

    // Combinations

    public static boolean isThreeOfAKind(ArrayList<String> cardRanks, List<String> cardRanksDistinct) {
        try {
            for (String cardRank : cardRanks) {
                if (cardRanksDistinct.size() == 3 && Collections.frequency(cardRanks, cardRank) == 3)
                    return true;
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in isThreeOfAKind: " + e);
        }

        return false;

    }


    public static boolean isRoyalFlash(ArrayList<String> cardRanks, HashSet<String> cardSuits) {
        try {
            if (cardRanks.containsAll(royalFlushList) && cardSuits.size() == 1)
                return true;
        } catch (Exception e) {
            System.out.println("Exception occurred in isRoyalFlash: " + e);
        }
        return false;

    }

    public static boolean isStraightFlash(ArrayList<String> cardRanks, HashSet<String> cardSuits) {
        try {
            if (cardRanks.containsAll(straightFlushList) && cardSuits.size() == 1)
                return true;
        } catch (Exception e) {
            System.out.println("Exception occurred in isStraightFlash: " + e);
        }

        return false;
    }

    public static boolean isFourOfAKind(ArrayList<String> cardRanks) {
        try {
            for (String cardRank : cardRanks) {
                if (Collections.frequency(cardRanks, cardRank) == 4)
                    return true;
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in isFourOfAKind: " + e);
        }

        return false;
    }

    public static boolean isFullHouse(ArrayList<String> cardRanks, List<String> cardRanksDistinct) {
        try {
            for (String cardRank : cardRanks) {
                if (cardRanksDistinct.size() == 2 && Collections.frequency(cardRanks, cardRank) == 3)
                    return true;
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in isFullHouse: " + e);
        }

        return false;
    }

    public static boolean isFlush(ArrayList<String> cardRanks, HashSet<String> cardSuits) {
        try {
            for (String cardRank : cardRanks) {
                if (!(cardSuits.size() == 1 && Collections.frequency(cardRanks, cardRank) < 2))
                    return false;
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in isFlush: " + e);
        }

        return true;
    }

    public static boolean isTwoPair(ArrayList<String> cardRanks) {
        try {
            int twoPairCounter = 0;
            for (String cardRank : cardRanks) {
                if (Collections.frequency(cardRanks, cardRank) == 2)
                    twoPairCounter++;
            }
            if (twoPairCounter == 4)
                return true;
        } catch (Exception e) {
            System.out.println("Exception occurred in isTwoPair: " + e);
        }

        return false;
    }

    public static boolean isStraight(ArrayList<String> cardRanks, HashSet<String> cardSuits) {
        try {
            if (cardRanks.containsAll(straightFlushList) && cardSuits.size() != 1)
                return true;

            Collections.sort(cardRanks);
            if (cardSuits.size() != 1)
                for (int i = 1; i < cardRanks.size(); i++) {
                    if (Integer.parseInt(cardRanks.get(i)) != Integer.parseInt(cardRanks.get(i - 1)) + 1)
                        return false;
                }
        } catch (Exception e) {
            System.out.println("Exception occurred in isStraight: " + e);
        }

        return true;
    }

    public static boolean isPair(ArrayList<String> cardRanks) {
        try {
            int pairCounter = 0;
            for (String cardRank : cardRanks) {
                if (Collections.frequency(cardRanks, cardRank) == 2)
                    pairCounter++;
            }
            if (pairCounter == 2)
                return true;
        } catch (Exception e) {
            System.out.println("Exception occurred in isPair: " + e);
        }

        return false;
    }

    public static String findHighCard(ArrayList<String> cardRanks) {
        try {
            if (cardRanks.contains("Ace"))
                return "High Card is: Ace";
            else if (cardRanks.contains("King"))
                return "High Card is: King";
            else if (cardRanks.contains("Queen"))
                return "High Card is: Queen";
            else if (cardRanks.contains("Jack"))
                return "High Card is: Jack";
            else {
                return "High Card is: " + findBiggestDecimal(cardRanks).toString();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in findHighCard: " + e);
        }
        return null;

    }

    public static String combinationResult(ArrayList<String> cardRanks, HashSet<String> cardSuits, List<String> cardRanksDistinct) {
        if (isRoyalFlash(cardRanks, cardSuits)) {
            return "Royal Flush";
        } else if (isStraightFlash(cardRanks, cardSuits)) {
            return "Straight Flush";
        } else if (isFourOfAKind(cardRanks)) {
            return "Four of a Kind";
        } else if (isFullHouse(cardRanks, cardRanksDistinct)) {
            return "Full House";
        } else if (isFlush(cardRanks, cardSuits)) {
            return "Flush";
        } else if (isStraight(cardRanks, cardSuits)) {
            return "Straight";
        } else if (isThreeOfAKind(cardRanks, cardRanksDistinct)) {
            return "Three Of A Kind";
        } else if (isTwoPair(cardRanks)) {
            return "Two Pair";
        } else if (isPair(cardRanks)) {
            return "Pair";
        } else {
            return findHighCard(cardRanks);
        }


    }


}
