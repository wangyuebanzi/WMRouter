package com.sankuai.waimai.router.demo.basic;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.foolman.demolib1api.contants.Contants;
import com.foolman.test.page.TestUriRequestActivity;
import com.sankuai.waimai.router.Router;
import com.sankuai.waimai.router.common.DefaultUriRequest;
import com.sankuai.waimai.router.core.OnCompleteListener;
import com.sankuai.waimai.router.core.UriRequest;
import com.sankuai.waimai.router.demo.R;
import com.foolman.common.BaseActivity;
import com.foolman.demolib2api.contants.Constant;
import com.foolman.common.util.ToastUtils;

/**
 * 基本用法Demo
 * <p>
 * Created by jzj on 2018/4/19.
 */

public class MainActivity extends BaseActivity {

    public static final String[] URIS = {
            // 基本页面跳转，支持不配置Scheme、Host，支持多个path
            com.foolman.testapi.constants.Constant.JUMP_ACTIVITY_1,
            com.foolman.testapi.constants.Constant.JUMP_ACTIVITY_2,

            // Kotlin
            com.foolman.demokotlinapi.Constant.KOTLIN,

            // request跳转测试
            com.foolman.testapi.constants.Constant.JUMP_WITH_REQUEST,

            // 自定义Scheme、Host测试；外部跳转测试
            com.foolman.testapi.constants.Constant.DEMO_SCHEME + "://" + com.foolman.testapi.constants.Constant.DEMO_HOST
                    + com.foolman.testapi.constants.Constant.EXPORTED_PATH,
            com.foolman.testapi.constants.Constant.DEMO_SCHEME + "://" + com.foolman.testapi.constants.Constant.DEMO_HOST
                    + com.foolman.testapi.constants.Constant.NOT_EXPORTED_PATH,

            // Library工程测试
            Contants.TEST_LIB1,
            Constant.TEST_LIB2,

            // 拨打电话
            com.sankuai.waimai.router.demo.constants.Constant.TEL,

            // 降级策略
            com.sankuai.waimai.router.demo.constants.Constant.TEST_NOT_FOUND,

            // Fragment test
            com.sankuai.waimai.router.demo.constants.Constant.JUMP_FRAGMENT_ACTIVITY,

            // Fragment to Fragment test
            com.sankuai.waimai.router.demo.constants.Constant.TEST_FRAGMENT_TO_FRAGMENT_ACTIVITY,

            // 高级Demo页面
            com.sankuai.waimai.router.demo.constants.Constant.ADVANCED_DEMO,
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
        if (com.foolman.testapi.constants.Constant.JUMP_WITH_REQUEST.equals(uri)) {
            new DefaultUriRequest(this, uri)
                    .activityRequestCode(100)
                    .putExtra(TestUriRequestActivity.INTENT_TEST_INT, 1)
                    .putExtra(TestUriRequestActivity.INTENT_TEST_STR, "str")
                    .overridePendingTransition(R.anim.enter_activity, R.anim.exit_activity)
                    .onComplete(new OnCompleteListener() {
                        @Override
                        public void onSuccess(@NonNull UriRequest request) {
                            ToastUtils.showToast(request.getContext(), "跳转成功");
                        }

                        @Override
                        public void onError(@NonNull UriRequest request, int resultCode) {

                        }
                    })
                    .start();
        } else {
            Router.startUri(this, uri);
        }
    }
}
