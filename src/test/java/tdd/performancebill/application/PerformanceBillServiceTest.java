package tdd.performancebill.application;

import org.junit.Test;
import tdd.performancebill.domain.model.Performance;

import static org.junit.Assert.*;

public class PerformanceBillServiceTest {

    @Test
    public void calTragedyAmount_大于40人时_加收人头费() {
        verifyCalTragedyAmount(41, 41000);
    }

    @Test
    public void calTragedyAmount_不大于40人时_不加收人头费() {
        verifyCalTragedyAmount(40, 40000);
    }

    private void verifyCalTragedyAmount(int audience, int expected) {
        PerformanceBillService sut = new PerformanceBillService();

        Performance perf = new Performance("hamelet", audience);
        int amount = sut.calTragedyAmount(perf.getAudience());

        assertEquals(expected, amount);
    }

    @Test
    public void calComedyAmount_大于20人时_加收人头费() {
        verifyCalComedyAmount(21, 46800);
    }

    @Test
    public void calTragedyAmount_不大于20人时_不加收人头费() {
        verifyCalComedyAmount(20, 36000);
    }

    private void verifyCalComedyAmount(int audience, int expected) {
        PerformanceBillService sut = new PerformanceBillService();

        Performance perf = new Performance("hamelet", audience);
        int amount = sut.calComedyAmount(perf.getAudience());

        assertEquals(expected, amount);
    }


}