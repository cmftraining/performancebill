package tdd.performancebill.domain.model;

public class TragedyAmountStrategy extends AmountStrategy{
    @Override
    public int cal(int audience) {
        final int THRESHOLD = 20;
        final int EXTRA_UNIT_PRICE = 1000;
        final int BASE_PRICE = 40000;

        int amt = BASE_PRICE;
        if (audience > THRESHOLD) {
            amt += EXTRA_UNIT_PRICE * (audience - THRESHOLD);
        }
        return amt;
    }

}
