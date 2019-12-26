package tdd.performancebill.domain.model.amountstrategy;

public class ComedyAmountStrategy extends AmountStrategy{
    @Override
    public int cal(int audience) {
        final int BASE_PRICE = 30000;
        final int UNIT_PRICE = 300;

        final int THRESHOLD = 20;
        final int EXTRA_BASE_PRICE = 10000;
        final int EXTRA_UNIT_PRICE = 500;

        int amount = BASE_PRICE + UNIT_PRICE * audience;

        if (audience > THRESHOLD) {
            amount += EXTRA_BASE_PRICE + EXTRA_UNIT_PRICE * (audience - THRESHOLD);
        }
        return amount;
    }
}
