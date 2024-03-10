package de.buddelbubi.network;

import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.Authenticator;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class APIModel {

    private static final String API_URL = "https://api.clashofclans.com/v1/";
    protected static String token = null;

    public static boolean setToken(String token) {
        if(APIModel.token == null && token != null) {
            APIModel.token = token;
            return true;
        } else return false;
    }

    public static String sendRequestRaw(String endpoint, String method, Map<String, Object> requestParams) {

        if (requestParams != null && requestParams.size() == 0) requestParams = null;

        String resp = null;
        String uri = API_URL + endpoint;

        String requestText = "";
        if (requestParams != null) {
            requestText = new JSONObject(requestParams).toString();
        }

        try {
            URL url = new URL(uri);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod(method.toUpperCase());
            conn.setRequestProperty("authorization", "Bearer " + token);

            if (!requestText.isEmpty()) {
                conn.setDoOutput(true);
                conn.getOutputStream().write(requestText.getBytes());
            }
            StringBuilder result = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            resp = result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public static String urlEncode(Map<?,?> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?,?> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                    urlEncode(entry.getKey().toString()),
                    urlEncode(entry.getValue().toString())
            ));
        }
        return sb.toString();
    }

}
