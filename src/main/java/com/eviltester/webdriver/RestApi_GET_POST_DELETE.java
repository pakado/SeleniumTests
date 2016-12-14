package com.eviltester.webdriver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by pkdo10 on 12/14/2016.
 */
public class RestApi_GET_POST_DELETE {

    public static void main(String[] args) throws Exception {

        RestApi_GET_POST_DELETE http = new RestApi_GET_POST_DELETE();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();

        System.out.println("Testing 2 - Send Http POST request\n");
        http.sendPost();

        System.out.println("\nTesting 3 - Send Http GET request");
        http.sendGet();

        System.out.println("\nTesting 4 - Send Http DELETE request\n");
        http.sendDelete();

        System.out.println("Testing 5 - Send Http GET request");
        http.sendGet();
    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String apiGet = "http://pakado-wks:3000/posts";

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

    // HTTP POST request
    private void sendPost() throws Exception {

        String apiPost = "http://pakado-wks:3000/posts";
        URL url = new URL(apiPost);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept", "application / json");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        //String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
        String urlParameters = "title=C02G8416DRJM&author=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("Sending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    // HTTP DELETE request
    private void sendDelete()throws Exception{

        String apiDelete = "http://pakado-wks:3000/posts/2";

        try {
            URL url = new URL(apiDelete );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Accept", "application / json");

            System.out.println(conn.getResponseCode());
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
            }


        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}