package com.twirling.www.libgvr;

import android.app.Activity;
import android.app.Application;
import android.app.DownloadManager;
import android.database.ContentObserver;
import android.os.Bundle;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by MagicBean on 2016/02/23 11:11:38
 */
public class App extends Application {

    public static App INS;
    private WeakReference<Activity> mCurrentActivity;
    //
    public static Map<Long, ContentObserver> observers = new HashMap<Long, ContentObserver>();

    @Override
    public void onCreate() {
        super.onCreate();
        INS = this;
        Logger.init(Constants.APP_TAG)                 // default PRETTYLOGGER or use just init()
                .methodCount(3)                 // default 2
                .hideThreadInfo()               // default shown
                .logLevel(BuildConfig.DEBUG ? LogLevel.FULL : LogLevel.NONE)        // default LogLevel.FULL
                .methodOffset(2)                // default 0
                .logAdapter(null); //default AndroidLogAdapter
//        SharePreHelper.getIns().initialize(this, null);
//        initializeSocialSdk();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                mCurrentActivity = new WeakReference<Activity>(activity);
                Logger.i("showActivity onActivityCreated:" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Logger.i("showActivity onActivityStarted:" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Logger.i("showActivity onActivityResumed:" + activity.getClass().getSimpleName());
                if (mCurrentActivity != null) {
                    mCurrentActivity.clear();
                    mCurrentActivity = null;
                }
                mCurrentActivity = new WeakReference<Activity>(activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Logger.i("showActivity onActivityPaused:" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Logger.i("showActivity onActivityStopped:" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Logger.i("showActivity onActivityDestroyed:" + activity.getClass().getSimpleName());
//                mCurrentActivity.clear();
            }
        });
    }

    private void initializeSocialSdk() {
//        //微信 appid appsecret
//        PlatformConfig.setWeixin("wx47214887960b7089", "c4e6874610b2e68f8265973db902a9e8");
//        // QQ和Qzone appid appkey
//        PlatformConfig.setQQZone("1105134189", "c7zkrvggWrj3a3eo");
//        //新浪微博 appkey appsecret
//        PlatformConfig.setSinaWeibo("1510346764", "32cc9fb610a37756ed25cca5f023b0ea");
    }

    public static App getInst() {
        return INS;
    }

    public Activity getCurrentShowActivity() {
        return mCurrentActivity.get();
    }

    public static DownloadManager getDownloadManager() {
        return (DownloadManager) App.getInst().getSystemService(App.getInst().getApplicationContext().DOWNLOAD_SERVICE);
    }
}
