package lotto.domain;

import java.util.Arrays;

public enum Rank {
  FIRST(6, 2_000_000_000, false),
  SECOND(5, 30_000_000, true),
  THIRD(5, 1_500_000, false),
  FOURTH(4, 50_000, false),
  FIFTH(3, 5_000, false),
  MISS(0, 0, false);

  private final int matchCount;
  private final int prizeMoney;
  private final boolean matchBonus;

  Rank(int matchCount, int prizeMoney, boolean matchBonus) {
    this.matchCount = matchCount;
    this.prizeMoney = prizeMoney;
    this.matchBonus = matchBonus;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }

  public static Rank valueOf(int matchCount, boolean matchBonus) {
    return Arrays.stream(values())
        .filter(rank -> rank.matchCount == matchCount && rank.matchBonus == matchBonus)
        .findFirst()
        .orElse(MISS);
  }
}
