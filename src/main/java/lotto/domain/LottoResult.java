package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> resultRank;
    private final int purchasePrice;

    public LottoResult(int purchasePrice) {
        this.resultRank = new HashMap<>();
        this.purchasePrice = purchasePrice;
    }

    private LottoRank calculateRank(Lotto lotto, WinningLotto winningLotto) {
        int matchingCount = countMatchNums(lotto, winningLotto);
        boolean hasBonus = isBonusMatch(lotto, winningLotto);
        return LottoRank.getRank(matchingCount, hasBonus);
    }

    private int countMatchNums(Lotto lotto, WinningLotto winningLotto) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningLotto.getWinningNums().getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isBonusMatch(Lotto lotto, WinningLotto winningLotto) {
        return lotto.getNumbers().contains(winningLotto.getBonusNum());
    }

    public int getRankCount(LottoRank lottoRank) {
        return resultRank.getOrDefault(lottoRank, 0);
    }

    public Map<LottoRank, Integer> getResultRank() {
        return resultRank;
    }

    public void addResult(Lotto lotto, WinningLotto winningLotto) {
        LottoRank rank = calculateRank(lotto,winningLotto);
        if (!rank.equals(LottoRank.NONE)) {
            resultRank.put(rank, resultRank.getOrDefault(rank, 0) + 1);
        }
    }

    public double calculateProfitRate() {
        long totalPrize = resultRank.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getMoney() * entry.getValue())
                .sum();

        return (double) totalPrize / purchasePrice * 100;
    }
}
