package th3g3ntl3m3n.concertapp.data;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import th3g3ntl3m3n.concertapp.R;

/**
 * Created by th3g3ntl3m3n on 12/8/17.
 */

public class Constants {

    public static final String TAG = Constants.class.getSimpleName();
    public static final String DEFAULT = "NULL";

    public static final int ADMIN = 1000;
    public static final int MANAGER = 1001;
    public static final int EMPLOYEE = 1002;

    public static final int SIGNUPFRAGMENT = 0;
    public static final int LOGINFRAGMENT = 1;
    public static final int ACCOUNTFRAGMENT = 2;

    public static final int FRONTACTIVITYE = 0;
    public static final int EDITACTIVITYE = 1;
    public static final int DETAILACTIVITYE = 2;
    public static final int VIEWACTIVITYE = 3;
    public static final int VIEWDETAILACTIVITYE = 4;

    public static final int MAPVIEWACTIVITYE = 5;
    public static final int MAPVIEWM = 9;

    public static final int FRONTACTIVITYM = 6;
    public static final int VIEWREPORTACTIVITYM = 7;
    public static final int DETAILREPORTM = 8;
    public static final int DEEPDETAILM = 10;

    public static final int SETTINGACCOUNTACTIVITY = 0;
    public static final int SETTINGBRANCHACTIVITY = 1;
    public static final int SETTINGREPORTACTIVITY = 2;
    public static final int SETTINGACTIVITY = 3;
    public static final int SETTINGACCOUNTADD = 4;
    public static final int SETTINGAREA = 5;
    public static final int SETTINGAREAPUSKESMASADD = 6;

    private static final String SHAREDFILENAME = "login";
    private static final boolean USERLOGGEDINDEFAULT = false;
    private static final String LOGGEDIN = "userLoggedIn";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String USERTPYE = "usertype";
    private static final String POSITION = "position";
    private static final String AREANAME = "AREANAME";
    private static final String PUSKESMAS = "PUSKESMAS";
    private static final String BRANCH = "BRANCH";

    public static boolean isUserLoggedIn(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDFILENAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(LOGGEDIN, USERLOGGEDINDEFAULT);
    }

    public static boolean loginUser(Context context, String s1, String s2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDFILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String uname = sharedPreferences.getString(USERNAME, DEFAULT);
        String pass = sharedPreferences.getString(PASSWORD, DEFAULT);
        Log.d(TAG, "loginUser: " + uname + " " + pass);
        if (uname.equals(s1) && pass.equals(s2)) {
            editor.putBoolean(LOGGEDIN, true);
        }
        editor.apply();

        return isUserLoggedIn(context);
    }

    public static void loginUserWithInternetCreds(Context context, String s1, String s2, POJOResponse pojoResponse) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDFILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERNAME, s1);
        editor.putString(PASSWORD, s2);
        editor.putInt(USERTPYE, pojoResponse.getType());
        editor.putString(AREANAME, pojoResponse.getArea());
        if (pojoResponse.getType() == EMPLOYEE) {
            editor.putString(PUSKESMAS, pojoResponse.getPusk());
        }
        editor.putBoolean(LOGGEDIN, true);
        editor.apply();
    }


    public static int getUserType(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDFILENAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(USERTPYE, -1);
    }

    public static String getUsername(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDFILENAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(USERNAME, DEFAULT);
    }

    public static boolean logoutUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDFILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(LOGGEDIN);
        editor.apply();
        return !isUserLoggedIn(context);
    }

    public static void putPositionInPrefs(Context context, int position) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDFILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (getPositionFromPrefs(context) != -1) {
            editor.remove(POSITION);
            editor.putInt(POSITION, position);
            editor.apply();
        } else {
            editor.putInt(POSITION, position);
            editor.apply();
        }
    }

    public static int getPositionFromPrefs(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDFILENAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(POSITION, -1);
    }

    public static String getAreaName(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDFILENAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(AREANAME, "NULL");
    }

    public static String getPuskName(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDFILENAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(PUSKESMAS, "NULL");
    }

    public static String getBranchName(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDFILENAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(BRANCH, "NULL");
    }

    public static void setBranchName(Context context, String name) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDFILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(BRANCH, name);
        editor.apply();
    }



    public static HashMap<String, ArrayList<String>> getSY() {
        HashMap<String, ArrayList<String>> mapSY = new HashMap<>();

        ArrayList<String> tempList = new ArrayList<>();
        tempList.add("Jumlah Desa");
        tempList.add("Jumlah Posyandu");
        tempList.add("Jumlah Poskesdes");
        tempList.add("Jumlah Desa Melaksanakan P4K");

        mapSY.put("Jumlah Desa", tempList);

        tempList.clear();
        tempList = new ArrayList<>();
        tempList.add("Jmlh PKM");
        tempList.add("Jmlh PKM Memiliki Dokter Umum");
        tempList.add("KM Perawatan");
        tempList.add("Jmlh PKM Dengan Ruang Bersalin");
        tempList.add("Jmlh PKM PKRT");

        mapSY.put("JUMLAH PUSKESMAS", tempList);

        return mapSY;
    }

    public static AlertDialog showExitDialog(final Context context, final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.DialogTheme);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        activity.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
            }
        });
        return alert;
    }

//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//        Window window = getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.setStatusBarColor(getResources().getColor(R.color.pumkin));
//    }

}
