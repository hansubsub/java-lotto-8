package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = lotto.getNumbers().stream()
                    .sorted()
                    .toList();
            System.out.println(sortedNumbers);
        }
        System.out.println();
    }

    public void printStatistics(Map<LottoRank, Integer> resultMap, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + resultMap.getOrDefault(LottoRank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + resultMap.getOrDefault(LottoRank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultMap.getOrDefault(LottoRank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultMap.getOrDefault(LottoRank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultMap.getOrDefault(LottoRank.FIRST, 0) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
