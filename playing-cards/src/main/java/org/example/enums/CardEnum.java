package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.common.Define;

@AllArgsConstructor
@Getter
public enum CardEnum {
  SPADE("スペード", Define.CARD_COLOR_BLACK),
  CLUB("クラブ", Define.CARD_COLOR_BLACK),
  HEART("ハート", Define.CARD_COLOR_RED),
  DIAMOND("ダイヤ", Define.CARD_COLOR_RED),
  JOKER1("ジョーカー", Define.CARD_COLOR_BLACK),
  JOKER2("ジョーカー", Define.CARD_COLOR_RED);

  private final String type;
  private final String color;

}
