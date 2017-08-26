package cn.hx.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import cn.hx.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.button) {
            ARouter.getInstance().build("/module1/activity").navigation(this, 1, new NavCallback() {
                @Override
                public void onArrival(Postcard postcard) {
                    Log.d(TAG, "onArrival() called with: postcard = [" + postcard + "]");
                }
            });

        } else if (i == R.id.button2) {
            ARouter.getInstance().build("/module2/activity").navigation(this, 2, new NavigationCallback() {
                @Override
                public void onFound(Postcard postcard) {
                    Log.d(TAG, "onFound() called with: postcard = [" + postcard + "]");
                }

                @Override
                public void onLost(Postcard postcard) {
                    Log.d(TAG, "onLost() called with: postcard = [" + postcard + "]");
                }

                @Override
                public void onArrival(Postcard postcard) {
                    Log.d(TAG, "onArrival() called with: postcard = [" + postcard + "]");
                }

                @Override
                public void onInterrupt(Postcard postcard) {
                    Log.d(TAG, "onInterrupt() called with: postcard = [" + postcard + "]");
                }
            });

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult() called with: requestCode = [" + requestCode + "], resultCode = [" + resultCode + "], data = [" + data + "]");
        if (requestCode == 1) {

        } else if (requestCode == 2) {

        }
    }
}
