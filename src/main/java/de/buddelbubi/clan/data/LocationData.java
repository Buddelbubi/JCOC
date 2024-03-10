package de.buddelbubi.clan.data;

import org.json.JSONObject;

import java.util.Locale;

public class LocationData {

    private final JSONObject data;

    public LocationData(JSONObject data) {
        this.data = data;
    }

    public int getId() {
        return this.data.getInt("id");
    }

    public String getName() {
        return this.data.getString("name");
    }

    public boolean isCountry() {
        return this.data.getBoolean("isCountry");
    }

    public String getCountryCode() {
        return this.data.getString("countryCode");
    }

    public Locale getLocale() {
        return Locale.of(getName().toUpperCase());
    }


}
