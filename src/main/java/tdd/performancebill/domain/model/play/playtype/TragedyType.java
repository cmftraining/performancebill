package tdd.performancebill.domain.model.play.playtype;

import tdd.performancebill.domain.model.amountstrategy.AmountStrategy;
import tdd.performancebill.domain.model.amountstrategy.TradegyAmountStrategy;

public class TragedyType extends PlayType {
    static final String NAME = "tragedy";

    @Override
    public AmountStrategy getAmountStrategy() {
        return TradegyAmountStrategy.INSTANCE;
    }

    @Override
    public boolean is(String typeName) {
        return TragedyType.NAME.equals(typeName);
    }
}
