package org.example.game;

import org.example.common.Define;
import org.example.entity.Cards;
import org.example.entity.Deck;
import org.example.enums.CardEnum;

import java.util.Scanner;

public class DoubleUp {
//  弱→強
//  2・3・4・5・6・7・8・9・10・J・Q・K・A・Joker

  private final Deck deck;

  public DoubleUp() {
    deck = new Deck();
  }

  private Cards draw() {
    return deck.draw();
  }

  private int convertJoker(final Cards card) {
    return switch (card.suit()) {
      case CardEnum.JOKER1, CardEnum.JOKER2 -> 99;
      default -> card.num();
    };
  }

  private int convertAce(final int num) {
    return num == 1 ? 14 : num;
  }

  private int convert(final Cards card) {
    return convertAce(convertJoker(card));
  }

  public void game() {
    System.out.println("ダブルアップ　スタート");
    Cards card1 = draw();

    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("手札:" + card1.suit() + card1.StringNum());
      System.out.println("High(h) or Low(l) ? >>>");
      final String input = scanner.next();

      if (!Define.DOUBLE_UP_HIGH.equals(input) && !Define.DOUBLE_UP_LOW.equals(input)) continue;

      Cards card2 = draw();
      System.out.println("ドロー:" + card2.suit() + card2.StringNum());

      final int num1 = convert(card1);
      final int num2 = convert(card2);

      if (Define.DOUBLE_UP_HIGH.equals(input)) {
        if (num1 < num2) {
          System.out.println("勝ち");
        } else if (num1 > num2) {
          System.out.println("負け");
        } else {
          System.out.println("引き分け");
        }
      } else {
        if (num1 < num2) {
          System.out.println("負け");
        } else if (num1 > num2) {
          System.out.println("勝ち");
        } else {
          System.out.println("引き分け");
        }
      }
      card1 = card2;
    }
  }
}
