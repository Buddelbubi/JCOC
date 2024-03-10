package de.buddelbubi.utils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Format {

    public static String toTag(String string) {

        if(string.startsWith("#")) {
            string = encode(string);
        } else {
            string = "%23" + string;
        }
        return string;
    }

    public static String encode(String string) {
        return URLEncoder.encode(string, StandardCharsets.UTF_8);
    }

}
