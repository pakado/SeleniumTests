package com.eviltester.webdriver;

import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.rmi.server.ExportException;
import java.util.Scanner;

/**
 * Created by pkdo10 on 12/7/2016.
 */
public class Tests {
    @Test
    public void Test(){
        String apiGet = "http://pakado-wks:3000/posts";
        String apiDelete = "http://pakado-wks:3000/posts/2";
        String apiPost = "http://pakado-wks:3000/posts";
        try {
            URL url = new URL(apiGet);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application / json");

            System.out.println(conn.getResponseCode());
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
            }

            Scanner scan = new Scanner(url.openStream());
            String entireResponse = new String();
            while (scan.hasNext())
                entireResponse += scan.nextLine();

            System.out.println("Response : "+entireResponse);

            scan.close();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
