package de.buddelbubi.player.data;

public class Achievement {

    public Achievements[] getAllAchievements() {
        return Achievement.Achievements.values();
    }

    public enum Achievements {
        BIGGER_COFFERS
    }

}
