package de.buddelbubi;

import de.buddelbubi.network.APIModel;

public class JCOC {

    public static boolean login(String token) {
        return  APIModel.setToken(token);
    }

}
