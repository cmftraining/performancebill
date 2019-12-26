package tdd.performancebill.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tdd.performancebill.application.PerformanceBillService;
import tdd.performancebill.domain.model.performancebill.PerformanceBill;
import tdd.performancebill.domain.model.performancesummary.PerformanceSummary;

//TODO 将悲剧加收人头费的门槛由30人改为40人
@RestController
public class PerformanceBillController {



    @Autowired
    private PerformanceBillService service;

    @PostMapping("/api/performancebill")
    public PerformanceBill createBill(@RequestBody PerformanceSummary performanceSummary) {
        PerformanceBill bill = service.buildPerformanceBill(performanceSummary);

        return bill;
    }

}
