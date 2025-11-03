package lotto.domain;


import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;


public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public List<Lotto> createLottos(int purchaseAmount){
        validatePurchaseAmount(purchaseAmount);

        int lottoCount = purchaseAmount/LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for(int i=0; i<lottoCount;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private void validatePurchaseAmount(int purchaseAmount){
        if (purchaseAmount<LOTTO_PRICE||purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

}
