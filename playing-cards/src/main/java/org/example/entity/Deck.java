package org.example.entity;

import org.example.common.Define;
import org.example.enums.CardEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Deck {

  private final List<Cards> deck;

  public Deck() {
    deck = createDeck();
  }

  private List<Cards> createDeck() {
    return new ArrayList<>(Stream.of(CardEnum.values())
            .flatMap(suit -> IntStream.rangeClosed(1, getSuitNum(suit))
                    .mapToObj(value -> new Cards(suit, value, dispNum(suit, value))))
            .toList());
  }

  private String dispNum(final CardEnum suit, final int value) {
    if (suit == CardEnum.JOKER1 || suit == CardEnum.JOKER2) return "";

    return switch (value) {
      case 1 -> "A";
      case 11 -> "J";
      case 12 -> "Q";
      case 13 -> "K";
      default -> value + "";
    };
  }

  private int getSuitNum(final CardEnum card) {
    if (card == CardEnum.JOKER1) return Define.CARD_MIN_NUM;
    if (card == CardEnum.JOKER2) return Define.CARD_MIN_NUM;
    return Define.CARD_MAX_NUM;
  }

  public Cards draw() {
    final Random random = new Random();
    final int index = random.nextInt(deck.size());
    final Cards card = deck.get(index);
    deck.remove(index);

    return card;
  }
}
