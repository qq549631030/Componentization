package cn.hx.module2;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import cn.hx.base.BaseActivity;

@Route(path = "/module2/activity")
public class Module2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2);
    }
}
