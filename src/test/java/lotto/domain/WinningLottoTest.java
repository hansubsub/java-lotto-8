package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("당첨 번호가 6개가 아니면 예외 발생")
    @Test
    void 당첨번호_개수_예외발생() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개");
    }

    @DisplayName("당첨 번호가 1~45 범위를 벗어나면 예외 발생")
    @Test
    void 당첨번호_범위_예외발생() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 99), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45");
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외발생() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외 발생")
    @Test
    void 보너스번호_범위_예외발생() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45");
    }
}

