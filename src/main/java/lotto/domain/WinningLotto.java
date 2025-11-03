package lotto.domain;

import java.util.List;

public class WinningLotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final Lotto winningNums;
    private final int bonusNum;

    public WinningLotto(List<Integer> winningNums, int bonusNum){
        validateWinningNum(winningNums);
        validateBonusNum(bonusNum, winningNums);
        this.winningNums = new Lotto(winningNums);
        this.bonusNum = bonusNum;
    }

    private void validateWinningNum(List<Integer> winningNums){
        validateSize(winningNums);
        validateRange(winningNums);
        validateDuplicate(winningNums);
    }

    private void validateBonusNum(int bonusNum, List<Integer> winningNumbers) {
        validateBonusRange(bonusNum);
        validateBonusDuplicate(bonusNum, winningNumbers);
    }

    private void validateSize(List<Integer> winningNums){
        if (winningNums.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> winningNums){
        if(winningNums.stream().anyMatch(num -> num < MIN_NUMBER || num > MAX_NUMBER)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> winningNums){
        long distinctCount = winningNums.stream().distinct().count();
        if (distinctCount != winningNums.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateBonusRange(int bonusNum) {
        if (bonusNum < MIN_NUMBER || bonusNum > MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusDuplicate(int bonusNumber, List<Integer> winningNums) {
        if (winningNums.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }


    public Lotto getWinningNums() {
        return winningNums;
    }

    public int getBonusNum() {
        return bonusNum;
    }


}
