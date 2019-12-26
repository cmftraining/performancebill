package tdd.performancebill.domain.model.play;

import tdd.performancebill.domain.model.play.playtype.PlayType;

public class Play {
    String id;
    String name;
    PlayType type;

    public Play(String id, String name, PlayType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PlayType getType() {
        return type;
    }

    public int calAmount(int audience) {
        return type.getAmountStrategy().cal(audience);
    }

    public int calVolumnCredits(int audience) {
        return type.getVolumnCreditsStrategy().cal(audience);
//        int thisVolumeCredits = Math.max(audience - 30, 0);
//        if (type.is("comedy")) {
//            thisVolumeCredits += Math.floorDiv(audience, 5);
//        }
//        return thisVolumeCredits;
    }
}
