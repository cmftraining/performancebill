package tdd.performancebill.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tdd.performancebill.application.PerformanceBillService;
import tdd.performancebill.infrustructure.PerformanceBillRepository;
import tdd.performancebill.domain.model.Performance;
import tdd.performancebill.domain.model.PerformanceBill;
import tdd.performancebill.domain.model.PerformanceSummary;
import tdd.performancebill.domain.model.Play;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PerformanceBillController {

    Map<String, Play> plays = new HashMap<>();

    @Autowired
    PerformanceBillRepository repository;

    @Autowired
    PerformanceBillService service;

    //DONE 应合理分层
    //TODO 用策略模式抽象不同戏剧类别的算法
    //TODO 应将初始化戏剧楼层的功能提取出来
    //TODO 将戏剧定义到数据库中
    //TODO 将戏剧类型做成枚举型
    //TODO 字符串的比较,应将字面量放在前面
    //TODO 应将计算金额和计算积分提取成独立的方法

    @PostMapping("/api/performancebill")
    public PerformanceBill createBill(@RequestBody PerformanceSummary performanceSummary) {
        PerformanceBill bill = service.createBill2(performanceSummary);

        return bill;
    }
}
