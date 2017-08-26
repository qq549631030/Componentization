package cn.hx.module1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import cn.hx.base.BaseActivity;

@Route(path = "/module1/activity")
public class Module1Activity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "Module1Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1);

        findViewById(R.id.button1).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.button1) {
            Toast.makeText(this, "module1", Toast.LENGTH_SHORT).show();
            ARouter.getInstance().build("/module2/activity").navigation(this, new NavCallback() {
                @Override
                public void onArrival(Postcard postcard) {
                    Log.d(TAG, "onArrival() called with: postcard = [" + postcard + "]");
                }
            });
        }
    }
}
