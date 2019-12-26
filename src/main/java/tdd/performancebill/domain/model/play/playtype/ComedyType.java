package tdd.performancebill.domain.model.play.playtype;

import tdd.performancebill.domain.model.amountstrategy.AmountStrategy;
import tdd.performancebill.domain.model.amountstrategy.ComedyAmountStrategy;

public class ComedyType extends PlayType {
    @Override
    public AmountStrategy getAmountStrategy() {
        return new ComedyAmountStrategy();
    }

    @Override
    public boolean is(String typeName) {
        return "comedy".equals(typeName);
    }
}
