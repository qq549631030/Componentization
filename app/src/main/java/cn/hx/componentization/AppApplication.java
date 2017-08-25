package cn.hx.componentization;

import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

import cn.hx.base.BaseApplication;

/**
 * Created by huangxiang on 2017/8/25.
 */

public class AppApplication extends BaseApplication {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
