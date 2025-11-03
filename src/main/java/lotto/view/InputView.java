package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int readPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException  e) {
                System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
            }
        }
    }

            public List<Integer> readWinningNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                String[] parts = input.split(",");

                List<Integer> winningNums = Arrays.stream(parts)
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                return winningNums;
            } catch (NumberFormatException  e) {
                System.out.println("[ERROR] 로또 번호는 쉼표(,)로 구분된 숫자여야 합니다.");
            }
        }
    }

    public int readBonusNumber() {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException  e) {
                System.out.println("[ERROR] 입력 중 알 수 없는 오류가 발생했습니다.");
            }
        }
    }
}
