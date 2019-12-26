package tdd.performancebill.domain.model.play.playtype;

import tdd.performancebill.domain.model.amountstrategy.AmountStrategy;
import tdd.performancebill.domain.model.amountstrategy.ComedyAmountStrategy;

public class ComedyType extends PlayType {

    static final String NAME = "comedy";

    @Override
    public AmountStrategy getAmountStrategy() {
        return ComedyAmountStrategy.INSTANCE;
    }

    @Override
    public boolean is(String typeName) {
        return NAME.equals(typeName);
    }
}
