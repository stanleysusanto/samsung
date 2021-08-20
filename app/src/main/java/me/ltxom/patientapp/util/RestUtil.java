package me.ltxom.patientapp.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class RestUtil {
    private final static String USER_AGENT = "Gorilla/5.0";
    public final static String BASE_URL = "http://172.16.95.123:8080/";

    public static JsonObject sendGet(final String url) {
        final JsonObject[] result = {null};
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                URL obj = null;
                try {
                    obj = new URL(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                HttpURLConnection con;
                try {

                    con = (HttpURLConnection) obj.openConnection();

                    con.setConnectTimeout(5000);
                    con.setReadTimeout(5000);

                    con.setRequestMethod("GET");
                    con.setRequestProperty("User-Agent", USER_AGENT);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    System.out.println(response.toString());
                    result[0] = (JsonParser.parseString(response.toString()).getAsJsonObject());
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        while (result[0] == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result[0];

    }

    public static JsonObject sendPost(final String url) {
        final JsonObject[] result = {null};
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                URL obj = null;
                try {
                    obj = new URL(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                HttpURLConnection con;
                try {

                    con = (HttpURLConnection) obj.openConnection();

                    con.setConnectTimeout(5000);
                    con.setReadTimeout(5000);

                    con.setRequestMethod("POST");
                    con.setRequestProperty("User-Agent", USER_AGENT);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    System.out.println(response.toString());
                    result[0] = (JsonParser.parseString(response.toString()).getAsJsonObject());
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        while (result[0] == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result[0];

    }
}
