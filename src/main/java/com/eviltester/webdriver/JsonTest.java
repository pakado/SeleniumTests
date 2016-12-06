package com.eviltester.webdriver;

import org.junit.Test;

import java.net.URL;

/**
 * Created by pkdo10 on 12/1/2016.
 */
public class JsonTest {

    @Test
    public void JsonTests()throws Exception{
        URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=chicago&sensor=false&#8221;");
    }
}

