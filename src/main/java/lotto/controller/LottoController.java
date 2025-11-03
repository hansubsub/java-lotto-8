package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoMachine = new LottoMachine();
    }

    public void run(){
        int purchaseAmount = inputView.readPurchaseAmount();
        //로또 발행
        List<Lotto> purchasedLottos = lottoMachine.createLottos(purchaseAmount);
        outputView.printPurchasedLottos(purchasedLottos);
        //당첨번호 입력
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        //결과 계산
        LottoResult result = new LottoResult(purchaseAmount);
        for (Lotto lotto : purchasedLottos) {
            result.addResult(lotto, winningLotto);
        }
        //결과 출력
        outputView.printStatistics(result.getResultRank(), result.calculateProfitRate());
    }
}
