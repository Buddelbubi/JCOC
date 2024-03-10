package de.buddelbubi.clan.data;

import org.json.JSONObject;

public class League {

    private JSONObject data;

    public League(JSONObject data) {
        this.data = data;
    }

    public int getId() {
        return this.data.getInt("id");
    }

    public String getFull() {
        return this.data.getString("name");
    }

    public String getName() {
        return getFull().split("\\s+")[0];
    }

    public int getLevel() {
        String[] split = getFull().split("\\s+");
        return Integer.parseInt(split[split.length-1]);
    }

}
