package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("5개 일치 시 3등, 5개+보너스 일치 시 2등으로 집계된다.")
    @Test
    void 로또결과_정상집계() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto3rd = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto lotto2nd = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        LottoResult result = new LottoResult(2000);
        result.addResult(lotto3rd, winningLotto);
        result.addResult(lotto2nd, winningLotto);

        assertThat(result.getRankCount(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.getRankCount(LottoRank.SECOND)).isEqualTo(1);
    }

    @DisplayName("수익률 계산이 정상 동작한다.")
    @Test
    void 수익률_정상계산() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 1등

        LottoResult result = new LottoResult(1000);
        result.addResult(lotto, winningLotto);

        double rate = result.calculateProfitRate();
        assertThat(rate).isEqualTo(2000000000.0 / 1000 * 100);
    }
}
