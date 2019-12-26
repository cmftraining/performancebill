package tdd.performancebill.domain.model.play.playtype;

import tdd.performancebill.domain.model.amountstrategy.AmountStrategy;

abstract public class PlayType {
    abstract public AmountStrategy getAmountStrategy() ;

    abstract public boolean is(String typeName);
}
