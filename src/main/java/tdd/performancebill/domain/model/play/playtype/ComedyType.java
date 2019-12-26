package tdd.performancebill.domain.model.play.playtype;

import tdd.performancebill.domain.model.play.playtype.amountstrategy.AmountStrategy;
import tdd.performancebill.domain.model.play.playtype.amountstrategy.ComedyAmountStrategy;
import tdd.performancebill.domain.model.play.playtype.volumncreditsstrategy.ComedyVolumnCreditsStrategy;
import tdd.performancebill.domain.model.play.playtype.volumncreditsstrategy.VolumnCreditsStrategy;

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

    @Override
    public VolumnCreditsStrategy getVolumnCreditsStrategy() {
        return ComedyVolumnCreditsStrategy.INSTANCE;
    }
}
