package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("1000원 단위가 아닌 금액이면 예외 발생")
    @Test
    void 구입금액이_1000원_단위가_아니면_예외발생() {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.createLottos(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원");
    }

    @DisplayName("정상 금액 입력 시 올바른 개수의 로또 발행")
    @Test
    void 구입금액_입력_정상() {
        LottoMachine lottoMachine = new LottoMachine();

        int amount = 5000;
        assertThat(lottoMachine.createLottos(amount))
                .hasSize(5);
    }
}
