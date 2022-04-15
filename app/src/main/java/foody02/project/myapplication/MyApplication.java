package foody02.project.myapplication;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import b.laixuantam.myaarlibrary.helper.MyLifecycleHandler;
import b.laixuantam.myaarlibrary.helper.MyLog;
import foody02.project.myapplication.dependency.AppObjectProvider;
import foody02.project.myapplication.dependency.AppProvider;
import foody02.project.myapplication.dependency.ObjectProviderInterface;
import foody02.project.myapplication.helper.Consts;

public class MyApplication extends Application {

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Đăng ký ActivityLifecycleCallbacks để kiểm tra application có background running hay visible on screen
        registerActivityLifecycleCallbacks(new MyLifecycleHandler());

        MultiDex.install(this);
        if (Consts.MODE.equalsIgnoreCase("debug"))
            MyLog.isEnableLog = true;
        else
            MyLog.isEnableLog = false;

        ObjectProviderInterface objectProviderInterface = new AppObjectProvider(this);
        AppProvider.init(objectProviderInterface);

    }


}
