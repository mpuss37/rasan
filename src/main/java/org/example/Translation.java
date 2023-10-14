package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Translation{
    private URL url;
    private HttpURLConnection connection;
    private BufferedReader bufferedReader;
    private StringBuilder stringBuilder;
    private String outputText;

    void setApiUrl(String resourceText, String outLang, String targetLang) {
        try {
            String apiUrl = "https://api.mymemory.translated.net/get?q=" + resourceText + "&langpair=" + outLang + "|" + targetLang + "";
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
            targetLang = firstMatch.getString("source");
            outLang = firstMatch.getString("target");
            outputText = jsonResponse.getJSONObject("responseData").getString("translatedText");
            System.out.println(outputText);
            System.out.println(resourceText);
            System.out.println(targetLang);
            System.out.println(outLang);
        } catch (IOException e) {
            System.err.println(e);
        }

    }

}
