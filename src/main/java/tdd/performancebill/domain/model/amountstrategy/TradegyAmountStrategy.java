package tdd.performancebill.domain.model.amountstrategy;

public class TradegyAmountStrategy extends AmountStrategy {
    public static final AmountStrategy INSTANCE = new TradegyAmountStrategy();

    @Override
    public int cal(int audience) {
        final int BASE_PRICE = 40000;
        final int THRESHOLD = 40;
        final int EXTRA_UNIT_PRICE = 1000;

        int amount = BASE_PRICE;
        if (audience > THRESHOLD) {
            amount += EXTRA_UNIT_PRICE * (audience - THRESHOLD);
        }
        return amount;
    }
}
