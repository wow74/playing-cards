package org.example.entity;

import org.example.common.Define;
import org.example.enums.CardEnum;

import java.util.List;
import java.util.stream.IntStream;

public record Cards(
        CardEnum card,
        int num
) {

  private static String type;
  private static List<Integer> deck;

  public Cards(final CardEnum card, final int num) {
    validator(card, num);
    this.num = num;
    this.card = card;
    type = card.getType();
    deck = createCard(num);
  }

  private static void validator(final CardEnum card, final int num) {
    if (isJoker(card) && num != Define.CARD_MIN_NUM) {
      throw new IllegalArgumentException("The number of sheets is incorrect.");
    }

    if (!isJoker(card) && (Define.CARD_MIN_NUM > num || num > Define.CARD_MAX_NUM)) {
      throw new IllegalArgumentException("The number of sheets is incorrect.");
    }
  }

  private static boolean isJoker(final CardEnum type) {
    return switch (type) {
      case CardEnum.JOKER1, CardEnum.JOKER2 -> true;
      default -> false;
    };
  }

  private static List<Integer> createCard(final int num) {
    return IntStream.rangeClosed(1, num).boxed().toList();
  }

  public String getType() {
    return type;
  }

  public List<Integer> getDeck() {
    return deck;
  }

}
