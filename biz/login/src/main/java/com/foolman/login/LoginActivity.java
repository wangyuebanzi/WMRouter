package com.foolman.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.foolman.common.BaseActivity;
import com.foolman.common.services.ServiceManager;
import com.foolman.common.util.ToastUtils;
import com.foolman.loginapi.IAccountService;
import com.foolman.loginapi.constants.Constant;
import com.sankuai.waimai.router.annotation.RouterUri;

/**
 * 登录页
 * <p>
 * Created by jzj on 2018/3/19.
 */
@RouterUri(path = Constant.LOGIN)
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(LoginActivity.this, "登录成功");
                ServiceManager.getSingletonKeyService(IAccountService.class).notifyLoginSuccess();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        ToastUtils.showToast(LoginActivity.this, "登录取消");
        ServiceManager.getSingletonKeyService(IAccountService.class).notifyLoginCancel();
        super.onBackPressed();
    }
}
