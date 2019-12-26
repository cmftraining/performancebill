package tdd.performancebill.domain.model.play.playtype.volumncreditsstrategy;


public class TragedyVolumnCreditsStrategy extends VolumnCreditsStrategy{
    public static final TragedyVolumnCreditsStrategy INSTANCE
            = new TragedyVolumnCreditsStrategy();

    @Override
    public int cal(int audience) {
        return  Math.max(audience - 30, 0);
    }
}
