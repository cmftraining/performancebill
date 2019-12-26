package tdd.performancebill;

import org.junit.Test;

import static org.junit.Assert.*;

public class PerformanceBillControllerTest {

    @Test
    public void calTragedyAmount_大于40人时_加收人头费() {
        verifyCalTragedyAmount(41, 41000);
    }

    @Test
    public void calTragedyAmount_不大于40人时_不加收人头费() {
        verifyCalTragedyAmount(40, 40000);
    }

    private void verifyCalTragedyAmount(int audience, int expected) {
        PerformanceBillController sut = new PerformanceBillController();

        Performance perf = new Performance("hamelet", audience);
        int amount = sut.calTragedyAmount(perf.getAudience());

        assertEquals(expected, amount);
    }



}