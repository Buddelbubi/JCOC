package de.buddelbubi.clan.data;

import de.buddelbubi.clan.Clan;
import lombok.Getter;
import org.json.JSONObject;

public class StrippedClan {

    @Getter
    private final JSONObject data;

    public StrippedClan(JSONObject data) {
        this.data = data;
    }

    public String getTag() {
        return this.getData().getString("tag");
    }

    public String getName() {
        return this.getData().getString("name");
    }

    public int getLevel() {
        return this.getData().getInt("clanLevel");
    }

    public Clan get() {
        return new Clan(getTag());
    }

}
