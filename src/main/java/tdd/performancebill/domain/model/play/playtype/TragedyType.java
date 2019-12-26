package tdd.performancebill.domain.model.play.playtype;

import tdd.performancebill.domain.model.amountstrategy.AmountStrategy;
import tdd.performancebill.domain.model.amountstrategy.TradegyAmountStrategy;

public class TragedyType extends PlayType {
    @Override
    public AmountStrategy getAmountStrategy() {
        return new TradegyAmountStrategy();
    }

    @Override
    public boolean is(String typeName) {
        return "tragedy".equals(typeName);
    }
}
