package tdd.performancebill.domain.model.play.playtype.volumncreditesstrategy;

public class ComedyVolumnCreditesStrategy extends VolumnCreditsStrategy {
    public static final ComedyVolumnCreditesStrategy INSTANCE
            = new ComedyVolumnCreditesStrategy();

    @Override
    public int cal(int audience) {
        return Math.max(audience - 30, 0) + Math.floorDiv(audience, 5);
    }
}
