package io.gresse.hugo.tp2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Jonathan on 04/12/2017.
 */
public class UserStorage {
    public static final String USER_NAME = "USER_NAME";
    public static final String USER_EMAIL = "USER_EMAIL";

    public static void saveUserInfo(Context context, String name, String mail){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(USER_NAME, name);
        editor.putString(USER_EMAIL, mail);
        editor.apply();
    }


    public static boolean isUserLoged(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        if(pref.contains(USER_NAME) && pref.contains(USER_EMAIL)){
            return true;
        }
        return false;
    }

    public static String getUserName(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getString(USER_NAME, null);
    }

    public static String getUserMail(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getString(USER_EMAIL, null);
    }
}
