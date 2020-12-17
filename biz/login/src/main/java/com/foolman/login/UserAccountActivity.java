package com.foolman.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.foolman.loginapi.IAccountService;
import com.foolman.loginapi.constants.Constant;
import com.sankuai.waimai.router.annotation.RouterUri;
import com.foolman.common.BaseActivity;
import com.foolman.common.services.ServiceManager;

/**
 * 用户账户页，需要先登录
 *
 * Created by jzj on 2018/3/19.
 */
@RouterUri(path = Constant.ACCOUNT_WITH_LOGIN_INTERCEPTOR,
        interceptors = LoginInterceptor.class)
public class UserAccountActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("我的账户");
        setContentView(R.layout.activity_button);
        Button button = findViewById(R.id.button);
        button.setText("退出登录");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceManager.getSingletonKeyService(IAccountService.class).notifyLogout();
                finish();
            }
        });
    }
}
