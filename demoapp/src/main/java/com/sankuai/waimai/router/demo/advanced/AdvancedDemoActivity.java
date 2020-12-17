package com.sankuai.waimai.router.demo.advanced;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sankuai.waimai.router.Router;
import com.sankuai.waimai.router.annotation.RouterUri;
import com.sankuai.waimai.router.demo.R;
import com.foolman.common.BaseActivity;
import com.sankuai.waimai.router.demo.constants.Constant;

/**
 * Created by jzj on 2018/3/19.
 */
@RouterUri(path = com.sankuai.waimai.router.demo.constants.Constant.ADVANCED_DEMO)
public class AdvancedDemoActivity extends BaseActivity {

    public static final String[] URIS = {

            // Interceptor测试
            com.foolman.loginapi.constants.Constant.ACCOUNT_WITH_LOGIN_INTERCEPTOR,
            com.foolman.locationapi.constants.Constant.NEARBY_SHOP_WITH_LOCATION_INTERCEPTOR,

            // 正则测试
            "http://www.meituan.com",
            "http://www.google.com",

            // 跳转UriHandler；重定向测试
            "/browser?url=http%3a%2f%2fwww.meituan.com",

            // UriHandler显示Toast
            com.foolman.common.constants.Constant.SHOW_TOAST_HANDLER,

            // 根据AB策略跳转不同页面
            com.foolman.testapi.constants.Constant.HOME_AB_TEST,

            // ServiceLoader测试
            Constant.SERVICE_LOADER,
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = findViewById(R.id.layout_container);
        for (final String uri : URIS) {
            Button button = new Button(this);
            button.setAllCaps(false);
            button.setText(uri);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    jump(uri);
                }
            });
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            container.addView(button, params);
        }
    }

    private void jump(String uri) {
        Router.startUri(this, uri);
    }
}
