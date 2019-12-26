package tdd.performancebill.domain.model.play.playtype;

import tdd.performancebill.domain.model.play.playtype.amountstrategy.AmountStrategy;
import tdd.performancebill.domain.model.play.playtype.volumncreditsstrategy.VolumnCreditsStrategy;

abstract public class PlayType {
    abstract public AmountStrategy getAmountStrategy() ;

    abstract public boolean is(String typeName);

    public abstract VolumnCreditsStrategy getVolumnCreditsStrategy();
}
