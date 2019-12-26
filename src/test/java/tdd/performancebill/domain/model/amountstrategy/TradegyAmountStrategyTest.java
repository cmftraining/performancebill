package tdd.performancebill.domain.model.amountstrategy;

import org.junit.Test;
import tdd.performancebill.application.PerformanceBillService;

import static org.junit.Assert.*;

public class TradegyAmountStrategyTest {

    @Test
    public void cal_大于40人时_加收人头费() {
        verifyCal(41, 41000);
    }

    @Test
    public void cal_不大于40人时_不加收人头费() {
        verifyCal(40, 40000);
    }

    private void verifyCal(int audience, int expected) {
        TradegyAmountStrategy sut = new TradegyAmountStrategy();

        int amount = sut.cal(audience);

        assertEquals(expected, amount);
    }


}