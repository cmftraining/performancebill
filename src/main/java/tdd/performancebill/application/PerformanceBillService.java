package tdd.performancebill.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tdd.performancebill.domain.model.performancebill.PerformanceBill;
import tdd.performancebill.domain.model.performancesummary.Performance;
import tdd.performancebill.domain.model.performancesummary.PerformanceSummary;
import tdd.performancebill.domain.model.play.Play;
import tdd.performancebill.domain.model.play.playtype.ComedyType;
import tdd.performancebill.domain.model.play.playtype.TragedyType;
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
        plays.put("hamlet", new Play("hamelet", "Hamlet", new TragedyType()));
        plays.put("as-like", new Play("as-like", "As You Like It", new ComedyType()));
        plays.put("othello", new Play("othello", "Othello",new TragedyType()));

        int totalAmount = 0;
        int volumeCredits = 0;

        PerformanceBill bill = new PerformanceBill(
                performanceSummary.getCustomer());


        for (Performance perf : performanceSummary.getPerformances()) {
            Play play = plays.get(perf.getPlayId());
            int thisAmount = play.getType().getAmountStrategy().cal(perf.getAudience());

            //计算观众量积分
            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            if (play.getType().is("comedy")) {
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

}
