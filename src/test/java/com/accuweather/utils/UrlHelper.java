package com.accuweather.utils;

import com.accuweather.models.Key;
import com.accuweather.models.Session;

public class UrlHelper {

    public static String changeTheUrl(String url, Session session){
        int _session = url.indexOf(Key.DAILY);
        return url.substring(0, _session) + session.name().toLowerCase() + url.substring(_session + 5);
    }

}
