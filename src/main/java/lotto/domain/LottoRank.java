package lotto.domain;

public enum LottoRank {
    NONE(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);


    private final int matchNumberCount;
    private final boolean matchBonus;
    private final long money;

    LottoRank(int matchNumberCount, boolean matchBonus, long money) {
        this.matchNumberCount  = matchNumberCount;
        this.matchBonus = matchBonus;
        this.money = money;
    }

    public static LottoRank getRank(int matchNumberCount, boolean matchBonus) {
        if (matchNumberCount == SECOND.getMatchNumberCount() && matchBonus) {
            return SECOND;
        }
        for (LottoRank rank : values()) {
            if (rank.matchNumberCount == matchNumberCount && !rank.matchBonus) {
                return rank;
            }
        }
        return NONE;
    }

    public int getMatchNumberCount(){
        return matchNumberCount;
    }

    public boolean getMatchBonus(){
        return matchBonus;
    }

    public long getMoney(){
        return money;
    }

}