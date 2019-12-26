package tdd.performancebill.domain.model.play.playtype.amountstrategy;

import org.junit.Test;

import static org.junit.Assert.*;

public class TragedyAmountStrategyTest {

    @Test
    public void cal_大于40人时_加收人头费() {
        verifyCal(41, 41000);
    }

    @Test
    public void cal_不大于40人时_不加收人头费() {
        verifyCal(40, 40000);
    }

    private void verifyCal(int audience, int expected) {
        TragedyAmountStrategy sut = new TragedyAmountStrategy();

        int amount = sut.cal(audience);

        assertEquals(expected, amount);
    }


}