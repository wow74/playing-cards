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
      System.out.println("手札:" + card1.suit() + " " + card1.StringNum());
      System.out.println("High(h) or Low(l) ? >>>");
      final String input = scanner.next();

      if (!Define.DOUBLE_UP_HIGH.equals(input) && !Define.DOUBLE_UP_LOW.equals(input)) continue;

      final Cards card2 = draw();
      System.out.println("ドロー:" + card2.suit() + " " + card2.StringNum());

      final int result = Integer.compare(convert(card1), convert(card2));
      System.out.println(switch (result) {
        case 1 -> Define.DOUBLE_UP_HIGH.equals(input) ? "負け" : "勝ち"; // a > b
        case -1 -> Define.DOUBLE_UP_HIGH.equals(input) ? "勝ち" : "負け"; // a < b
        default -> "引き分け"; // a == b (0)
      });

      card1 = card2;

      System.out.println("ゲーム続行(y/n) >>>");
      if (scanner.next().equals(Define.DEFINE_NO)) break;
    }
  }
}
