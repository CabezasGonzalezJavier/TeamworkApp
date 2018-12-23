package com.example.javier.teamworkapp;

import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static com.example.javier.teamworkapp.Constants.*;

public abstract class Utils {

    private static final String TAG = Utils.class.getName();

    public static String getAuthStringUser() {
        byte[] data = new byte[0];
        try {
            data = (API_USER_NAME + ":" + API_PASSWORD).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }

    public static String convertStringDateToString(String dateInString) {
        String returnString="";

        SimpleDateFormat formatter = new SimpleDateFormat(SERVER_FORMAT);

        try {
            Date date = formatter.parse(dateInString.replaceAll("Z$", "+0000"));
            SimpleDateFormat formatEnd = new SimpleDateFormat(RIGHT_FORMAT);
            returnString=formatEnd.format(date);
        } catch (Exception e){
            Log.e(TAG,"error");
        }
        return returnString;
    }

    public static String convertTimeStampToString(String timeStamp) {
        Long thisLong = Long.valueOf(timeStamp);
        thisLong =thisLong * 1000;
        SimpleDateFormat sf = new SimpleDateFormat(RIGHT_FORMAT);
        Date date = new Date(thisLong);
        return sf.format(date);
    }
}
