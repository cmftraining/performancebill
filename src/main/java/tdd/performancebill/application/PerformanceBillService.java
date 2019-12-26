package tdd.performancebill.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tdd.performancebill.domain.model.Performance;
import tdd.performancebill.domain.model.PerformanceBill;
import tdd.performancebill.domain.model.PerformanceSummary;
import tdd.performancebill.domain.model.Play;
import tdd.performancebill.infrastrucure.PerformanceBillRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class PerformanceBillService {
    @Autowired
    PerformanceBillRepository repository;

    public PerformanceBill buildPerformanceBill(@RequestBody PerformanceSummary performanceSummary) {
        Map<String, Play> plays = new HashMap<>();
        //初始化戏剧列表
        plays.put("hamlet", new Play("hamelet", "Hamlet", "tragedy"));
        plays.put("as-like", new Play("as-like", "As You Like It", "comedy"));
        plays.put("othello", new Play("othello", "Othello", "tragedy"));

        int totalAmount = 0;
        int volumeCredits = 0;

        PerformanceBill bill = new PerformanceBill(
                performanceSummary.getCustomer());


        for (Performance perf : performanceSummary.getPerformances()) {
            Play play = plays.get(perf.getPlayId());
            int thisAmount = calAmount(perf.getAudience(), play.getType());

            //计算观众量积分
            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            if ("comedy".equals(play.getType())) {
                volumeCredits += Math.floorDiv(perf.getAudience(), 5);
            }

            totalAmount += thisAmount;

            bill.addItem(play.getName(),thisAmount, perf.getAudience());


        }

        bill.setTotalAmount(totalAmount);
        bill.setVolumeCredits(volumeCredits);

        repository.save(bill);
        return bill;
    }

    private int calAmount(int audience, String playType) {
        int thisAmount;
        if (playType.equals("tragedy")) {
            thisAmount = calTragedyAmount(audience);
        } else if (playType.equals("comedy")) {
            thisAmount = calComedyAmount(audience);
        } else {
            throw new IllegalArgumentException("戏剧类型不正确!");
        }
        return thisAmount;
    }

    int calComedyAmount(int audience) {
        final int BASE_PRICE = 30000;
        final int UNIT_PRICE = 300;

        final int THRESHOLD = 20;
        final int EXTRA_BASE_PRICE = 10000;
        final int EXTRA_UNIT_PRICE = 500;

        int amount = BASE_PRICE + UNIT_PRICE * audience;

        if (audience > THRESHOLD) {
            amount += EXTRA_BASE_PRICE + EXTRA_UNIT_PRICE * (audience - THRESHOLD);
        }
        return amount;
    }

    int calTragedyAmount(int audience) {
        final int BASE_PRICE = 40000;
        final int THRESHOLD = 40;
        final int EXTRA_UNIT_PRICE = 1000;

        int amount = BASE_PRICE;
        if (audience > THRESHOLD) {
            amount += EXTRA_UNIT_PRICE * (audience - THRESHOLD);
        }
        return amount;
    }

}
