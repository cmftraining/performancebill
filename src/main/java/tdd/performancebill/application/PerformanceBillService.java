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
            int thisAmount;

            if (play.getType().equals("tragedy")) {
                thisAmount = calTragedyAmount(perf.getAudience());
            } else if (play.getType().equals("comedy")) {
                thisAmount = 30000;
                if (perf.getAudience() > 20) {
                    thisAmount += 10000 + 500 * (perf.getAudience() - 20);
                }
                thisAmount += 300 * perf.getAudience();
            } else {
                throw new IllegalArgumentException("戏剧类型不正确!");
            }

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

    int calTragedyAmount(int audience) {
        final int BASE_PRICE = 40000;
        final int THRESHOLD = 40;
        final int UNIT_PRICE = 1000;

        int amount = BASE_PRICE;
        if (audience > THRESHOLD) {
            amount += UNIT_PRICE * (audience - THRESHOLD);
        }
        return amount;
    }

}
