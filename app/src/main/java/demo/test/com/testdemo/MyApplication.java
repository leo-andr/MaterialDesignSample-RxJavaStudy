package demo.test.com.testdemo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * @author fangwenjiao
 * @date 20152015年12月16日
 * @description
 */
public class MyApplication extends Application {
    public static List<Activity> activityList = null;
    public static SharedPreferences user = null;
    public static long timestamp;
    private static MyApplication instance;

    /**
     * @return the main context of the Application
     */
    public static Context getAppContext() {
        return instance;
    }

    public static MyApplication getInstance() {
        return instance;
    }

    /**
     * @return the main resources from the Application
     */
    public static Resources getAppResources() {
        return instance.getResources();
    }

    /**
     * 每打开一个Activity就添加到List里
     */
    public static void addActivity(Activity activity)//
    {
        if (null == activityList) {
            activityList = new ArrayList<>();
        }
        activityList.add(activity);
    }

    /**
     * 在要退出的时候遍历List逐个finish
     */
    public static void finishActivity() {
        if (null != activityList) {
            for (Activity att : activityList) {
                att.finish();
            }
        }
    }

    public static void removeActivity(Activity activity) {
        if (null != activityList) {
            activityList.remove(activity);
        }
    }

    public static Activity currentActivity() {
        if (null != activityList && activityList.size() > 0) {
            return activityList.get(activityList.size() - 1);
        } else {
            return null;
        }
    }

    public static void batchClosedActivity(Class clazz) {
        for (int i = activityList.size() - 1; i >= 0; i--) {
            Activity activity = activityList.get(i);
            if (activityList.get(i).getClass().equals(clazz)) {
                return;
            }
            activityList.remove(activity);
            activity.finish();
        }

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    /*
     * @see android.app.Application#onCreate()
     */
    @Override
    public void onCreate() {
        super.onCreate();
        user = this.getSharedPreferences("user", MODE_PRIVATE);
        // Are we using advanced debugging - locale?
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String p = pref.getString("set_locale", "");
        if (!p.equals("")) {
            Locale locale;
            locale = p.startsWith("zh") ? Locale.CHINA : new Locale(p);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
        }
        instance = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
