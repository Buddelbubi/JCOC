package de.buddelbubi.clan;

import de.buddelbubi.clan.data.ClanType;
import de.buddelbubi.clan.data.League;
import de.buddelbubi.clan.data.LocationData;
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

    public String getName() {
        return getString("name");
    }

    public ClanType getType() {
        return ClanType.getType(getString("type"));
    }

    public String getDescription() {
        return getString("description");
    }

    public LocationData getLocationData() {
        return new LocationData(getData().getJSONObject("location"));
    }

    public boolean isFamilyFriendly() {
        return getData().getBoolean("isFamilyFriendly");
    }

    public int getLevel() {
        return getInt("clanLevel");
    }

    public int getTrophies() {
        return getInt("clanPoints");
    }

    public int getBuilderTrophies() {
        return getInt("clanBuilderBasePoints");
    }

    public int getCapitalTrophies() {
        return getInt("clanCapitalPoints");
    }

    public League getCapitalLeague() {
        return new League(getData().getJSONObject("capitalLeague"))
    }

    public int getRequiredTrophies() {
        return getInt("requiredTrophies");
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

    protected String getString(String key) {
        return this.getData().getString(key);
    }
    protected int getInt(String key) {
        return this.getData().getInt(key);
    }
}
