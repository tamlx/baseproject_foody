package foody02.project.myapplication.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.Locale;

import b.laixuantam.myaarlibrary.helper.LanguageHelper;
import foody02.project.myapplication.model.UserRegisterModel;
import foody02.project.myapplication.model.customer.OrderHistoryDetailModel;
import foody02.project.myapplication.model.customer.OrderHistoryModel;

public class SharePrefs {

    public static final String DEFAULT_BLANK = "";

    private SharedPreferences sharedPreferences;

    public SharePrefs(Context ctx) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public void clear() {
        // clear all
        sharedPreferences.edit().clear().commit();
    }

    public void clear(String key) {

        save(key, "");
    }

    public void save(String key, String value) {
        if (!TextUtils.isEmpty(value))
            sharedPreferences.edit().putString(key, value).commit();
        else
            sharedPreferences.edit().putString(key, DEFAULT_BLANK).commit();
    }

    public void save(String key, long value) {
        sharedPreferences.edit().putLong(key, value).commit();
    }

    public void save(String key, float value) {
        sharedPreferences.edit().putFloat(key, value).commit();
    }

    public String get(String key, String _default) {
        return sharedPreferences.getString(key, _default);
    }

    public double get(String key, float _default) {
        return sharedPreferences.getFloat(key, _default);
    }

    public long get(String key, long defValue) {
        return sharedPreferences.getLong(key, defValue);
    }

    public int get(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    public void save(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).commit();
    }

    public void save(String key, int value) {
        sharedPreferences.edit().putInt(key, value).commit();
    }

    public boolean get(String key, boolean _default) {
        return sharedPreferences.getBoolean(key, _default);
    }

    private static final String PREF_USER_MODEL = "PREF_USER_MODEL";

    private final Gson gson = new Gson();

    public void saveUserModel(UserRegisterModel model) {
        save(PREF_USER_MODEL, gson.toJson(model));
    }

    public UserRegisterModel getUserModel() {
        String json = get(PREF_USER_MODEL, "");
        if (!TextUtils.isEmpty(json)) {
            return gson.fromJson(json, UserRegisterModel.class);
        }
        return null;
    }

    private static final String PREF_ORDER_HISTORY_DETAIL_MODEL = "PREF_ORDER_HISTORY_DETAIL_MODEL";

    public void saveOrderHistoryDetailModel(OrderHistoryDetailModel model) {
        save(PREF_ORDER_HISTORY_DETAIL_MODEL, gson.toJson(model));
    }

    public OrderHistoryDetailModel getOrderHistoryDetailModel() {
        String json = get(PREF_ORDER_HISTORY_DETAIL_MODEL, "");
        if (!TextUtils.isEmpty(json)) {
            return gson.fromJson(json, OrderHistoryDetailModel.class);
        }
        return null;
    }

    private static final String PREF_ORDER_HISTORY_MODEL = "PREF_ORDER_HISTORY_MODEL";

    public void saveOrderHistoryModel(OrderHistoryModel model) {
        save(PREF_ORDER_HISTORY_MODEL, gson.toJson(model));
    }

    public OrderHistoryModel getOrderHistoryModel() {
        String json = get(PREF_ORDER_HISTORY_MODEL, "");
        if (!TextUtils.isEmpty(json)) {
            return gson.fromJson(json, OrderHistoryModel.class);
        }
        return null;
    }

    private static final String PREF_STATUS_LOGIN = "PREF_STATUS_LOGIN";
    public void saveStatusLogin(boolean value) {
        save(PREF_STATUS_LOGIN, value);
    }

    public boolean checkLoginStatus() {
        return get(PREF_STATUS_LOGIN, false);
    }
}
