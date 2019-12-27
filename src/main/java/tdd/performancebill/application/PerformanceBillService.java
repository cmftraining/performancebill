package tdd.performancebill.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tdd.performancebill.domain.model.*;
import tdd.performancebill.infrustructure.PerformanceBillRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class PerformanceBillService {

    @Autowired
    PerformanceBillRepository repository;

    public PerformanceBill createBill2(@RequestBody PerformanceSummary performanceSummary) {
        Map<String, Play> plays = new HashMap<>();
        //初始化戏剧列表
        plays.put("hamlet", new Play("hamelet", "Hamlet", new StrategyType()));
        plays.put("as-like", new Play("as-like", "As You Like It", new ComedyType());
        plays.put("othello", new Play("othello", "Othello", new StrategyType());

        int totalAmount = 0;
        int volumeCredits = 0;

        PerformanceBill bill = new PerformanceBill(
                performanceSummary.getCustomer());


        for (Performance perf : performanceSummary.getPerformances()) {
            Play play = plays.get(perf.getPlayId());
            int thisAmount;

            AmountStrategy amountStrategy = play.getType().getAmountStrategy();

            thisAmount = amountStrategy.cal(perf.getAudience());

            //计算观众量积分
            volumeCredits += calThisVolumeCredits(perf.getAudience(), play.getType());

            totalAmount += thisAmount;

            bill.addItem(play.getName(),thisAmount, perf.getAudience());


        }

        bill.setTotalAmount(totalAmount);
        bill.setVolumeCredits(volumeCredits);

        repository.save(bill);
        return bill;
    }

    int calComedyAmount(int audience) {
        int thisAmount;
        thisAmount = 30000;
        if (audience > 20) {
            thisAmount += 10000 + 500 * (audience - 20);
        }
        thisAmount += 300 * audience;
        return thisAmount;
    }

    int calThisVolumeCredits(int audience, String playType) {
        int thisVolumeCredits = 0;
        thisVolumeCredits += Math.max(audience - 30, 0);
        if ("comedy".equals(playType)) {
            thisVolumeCredits += Math.floorDiv(audience, 5);
        }
        return thisVolumeCredits;
    }

    int calTragedyAmount(int audience) {
        final int THRESHOLD = 20;
        final int EXTRA_UNIT_PRICE = 1000;
        final int BASE_PRICE = 40000;

        int amt = BASE_PRICE;
        if (audience > THRESHOLD) {
            amt += EXTRA_UNIT_PRICE * (audience - THRESHOLD);
        }
        return amt;
    }
}
