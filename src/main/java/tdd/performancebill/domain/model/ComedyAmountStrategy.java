package tdd.performancebill.domain.model;

public class ComedyAmountStrategy extends AmountStrategy{
    @Override
    public int cal(int audience) {
        int thisAmount;
        thisAmount = 30000;
        if (audience > 20) {
            thisAmount += 10000 + 500 * (audience - 20);
        }
        thisAmount += 300 * audience;
        return thisAmount;
    }
}
