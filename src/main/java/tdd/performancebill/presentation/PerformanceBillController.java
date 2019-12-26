package tdd.performancebill.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tdd.performancebill.application.PerformanceBillService;
import tdd.performancebill.domain.model.Performance;
import tdd.performancebill.domain.model.PerformanceBill;
import tdd.performancebill.domain.model.PerformanceSummary;
import tdd.performancebill.domain.model.Play;
import tdd.performancebill.infrastrucure.PerformanceBillRepository;

import java.util.HashMap;
import java.util.Map;

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
