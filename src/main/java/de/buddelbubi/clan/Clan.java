package de.buddelbubi.clan;

import de.buddelbubi.network.APIModel;
import de.buddelbubi.utils.Format;
import lombok.Getter;
import org.json.JSONObject;

public class Clan {

    @Getter
    private final String tag;
    @Getter
    private JSONObject data;

    public Clan(String tag) {
        this.tag = tag;
        init();
    }

    public Clan(String tag, boolean init) {
        this.tag = tag;
        if(init) init();
    }

    public boolean init() {
        if(data == null) {
            try {
                JSONObject response = new JSONObject(APIModel.sendRequestRaw(String.format("clans/%s", Format.toTag(getTag())), "get", null));
                data = response;
                return true;
            } catch (Exception e) {
                return false;
            }
        } else return false;
    }
}
