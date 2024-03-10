package de.buddelbubi.player;

import de.buddelbubi.clan.Clan;
import de.buddelbubi.clan.data.StrippedClan;
import de.buddelbubi.network.APIModel;
import de.buddelbubi.utils.Format;
import lombok.Getter;
import org.json.JSONObject;

import java.util.HashMap;

public class Player {

    @Getter
    private final String tag;
    @Getter
    private JSONObject data;

    public Player(String tag) {
        this.tag = tag;
        this.init();
    }

    public Player(String tag, boolean init) {
        this.tag = tag;
        if(init) this.init();
    }

    public String getName() {
        return getString("name");
    }

    public int getTownHallLevel() {
        return getInt("townHallLevel");
    }

    public int getTownHallWeaponLevel() {
        return getInt("townHallWeaponLevel");
    }

    public int getExperienceLevel() {
        return getInt("expLevel");
    }

    public int getTrophies() {
        return getInt("trophies");
    }

    public int getBestTrophies() {
        return getInt("bestTrophies");
    }

    public int getWarStars() {
        return getInt("warStars");
    }

    public int getAttackWins() {
        return getInt("attackWins");
    }

    public int getDefenseWins() {
        return getInt("defenseWins");
    }

    public int getBuilderHallLevel() {
        return  getInt("builderHallLevel");
    }

    public int getBuilderTrophies() {
        return getInt("builderBaseTrophies");
    }

    public int getBestBuilderTrophies() {
        return getInt("bestBuilderBaseTrophies");
    }

    public String getRole() {
        //What is a role??
        return getString("role");
    }

    public boolean wantWar() {
        return getString("warPreference").equals("in");
    }

    public int getDonatedTroups() {
        return getInt("donations");
    }

    public int getReceivedTroups() {
        return getInt("donationsReceived");
    }

    public int getClanCapitalContibutions() {
        return getInt("clanCapitalContributions");
    }

    public StrippedClan getClanStripped() {
        return new StrippedClan(getData().getJSONObject("clan"));
    }

    public Clan getClan() {
        return getClanStripped().get();
    }

    public boolean init() {
        if(data == null) {
            try {
                JSONObject response = new JSONObject(APIModel.sendRequestRaw(String.format("players/%s", Format.toTag(getTag())), "get", null));
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

    public boolean verifyToken(String token) {
        String tag = Format.toTag(getTag());
        HashMap<String, Object> params = new HashMap<>();
        params.put("token", token);
        JSONObject response = new JSONObject(APIModel.sendRequestRaw(String.format("players/%s/verifytoken", tag), "get", params));
        return response.getString("status").equals("ok");
    }

}
