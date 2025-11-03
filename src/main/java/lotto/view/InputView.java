package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public WinningLotto readWinningNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> winningNums = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                System.out.println("\n보너스 번호를 입력해 주세요.");
                int bonusNum = Integer.parseInt(Console.readLine().trim());

                return new WinningLotto(winningNums, bonusNum);
            } catch (Exception e) {}
        }
    }

    public int readBonusNumber() {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                return Integer.parseInt(input.trim());
            } catch (Exception e) {}
        }
    }
}
