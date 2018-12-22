package com.example.javier.teamworkapp;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static com.example.javier.teamworkapp.Constants.API_PASSWORD;
import static com.example.javier.teamworkapp.Constants.API_USER_NAME;

public abstract class Utils {

    public static String getAuthStringUser() {
        byte[] data = new byte[0];
        try {
            data = (API_USER_NAME + ":" + API_PASSWORD).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }

    public static String convertTimeStampToString(String timestamp) {
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(Long.parseLong(timestamp));
        return sdf.format(date);
    }
}
