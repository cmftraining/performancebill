package tdd.performancebill.domain.model.play.playtype.amountstrategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComedyAmountStrategyTest {
    @Test
    public void cal_大于20人时_加收人头费() {
        verifyCal(21, 46800);
    }

    @Test
    public void cal_不大于20人时_不加收人头费() {
        verifyCal(20, 36000);
    }

    private void verifyCal(int audience, int expected) {
        ComedyAmountStrategy sut = new ComedyAmountStrategy();

        int amount = sut.cal(audience);

        assertEquals(expected, amount);
    }
}

