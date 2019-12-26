package tdd.performancebill.domain.model.play.playtype;

import tdd.performancebill.domain.model.play.playtype.amountstrategy.AmountStrategy;
import tdd.performancebill.domain.model.play.playtype.amountstrategy.TragedyAmountStrategy;
import tdd.performancebill.domain.model.play.playtype.volumncreditsstrategy.TragedyVolumnCreditsStrategy;
import tdd.performancebill.domain.model.play.playtype.volumncreditsstrategy.VolumnCreditsStrategy;

public class TragedyType extends PlayType {
    static final String NAME = "tragedy";

    @Override
    public AmountStrategy getAmountStrategy() {
        return TragedyAmountStrategy.INSTANCE;
    }

    @Override
    public boolean is(String typeName) {
        return TragedyType.NAME.equals(typeName);
    }

    @Override
    public VolumnCreditsStrategy getVolumnCreditsStrategy() {
        return TragedyVolumnCreditsStrategy.INSTANCE;
    }
}
