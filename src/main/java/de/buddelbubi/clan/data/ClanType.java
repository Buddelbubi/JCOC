package de.buddelbubi.clan.data;

public enum ClanType {

    OPEN,
    CLOSED,
    INVITE;

    public static ClanType getType(String type) {
        switch (type) {
            case "open":
                return ClanType.OPEN;
            case "closed":
                return ClanType.CLOSED;
            case "inviteOnly":
                return ClanType.INVITE;
        }
        return null;
    }

}
