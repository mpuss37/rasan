package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Translation {
    private URL url;
    private HttpURLConnection connection;
    private BufferedReader bufferedReader;
    private StringBuilder stringBuilder;
    private String outputText,apiUrl,encodeResourceText;

    void setApiUrl(String pages, String resourceText, String outLang, String targetLang) {
        try {
            encodeResourceText = URLEncoder.encode(resourceText, "UTF-8");
            apiUrl = "https://api.mymemory.translated.net/get?q=" + encodeResourceText + "&langpair=" + outLang + "|" + targetLang + "";
            url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            stringBuilder = new StringBuilder();
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            bufferedReader.close();
            connection.disconnect();
            JSONObject jsonResponse = new JSONObject(stringBuilder.toString());
            JSONArray jsonArray = jsonResponse.getJSONArray("matches");
            JSONObject firstMatch = jsonArray.getJSONObject(0);
            resourceText = firstMatch.getString("segment");
            if (pages == "from") {
                outLang = firstMatch.getString("target");
            }else {
                outLang = firstMatch.getString("Autodetect");
            }
            targetLang = firstMatch.getString("source");
            outputText = jsonResponse.getJSONObject("responseData").getString("translatedText");
            System.out.println("From (ResourceText : " + resourceText + ", " + outLang + ") To (Translate text : " + outputText + ", : " + targetLang+")");
        } catch (IOException e) {
            System.err.println(apiUrl);
        }

    }

}
