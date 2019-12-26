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
}
