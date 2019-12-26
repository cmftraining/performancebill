package tdd.performancebill.domain.model.play.playtype.volumncreditsstrategy;

public class ComedyVolumnCreditsStrategy extends VolumnCreditsStrategy {
    public static final ComedyVolumnCreditsStrategy INSTANCE
            = new ComedyVolumnCreditsStrategy();

    @Override
    public int cal(int audience) {
        return Math.max(audience - 30, 0) + Math.floorDiv(audience, 5);
    }
}
