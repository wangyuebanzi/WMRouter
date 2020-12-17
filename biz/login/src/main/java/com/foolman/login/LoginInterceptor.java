package com.foolman.login;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.foolman.loginapi.IAccountService;
import com.sankuai.waimai.router.core.UriCallback;
import com.sankuai.waimai.router.core.UriInterceptor;
import com.sankuai.waimai.router.core.UriRequest;
import com.sankuai.waimai.router.core.UriResult;
import com.foolman.common.util.CustomUriResult;
import com.foolman.common.services.ServiceManager;

/**
 * Created by jzj on 2018/3/20.
 */

public class LoginInterceptor implements UriInterceptor {

    @Override
    public void intercept(@NonNull UriRequest request, @NonNull final UriCallback callback) {
        final IAccountService accountService = ServiceManager.getSingletonKeyService(IAccountService.class);
        if (accountService.isLogin()) {
            callback.onNext();
        } else {
            Toast.makeText(request.getContext(), "请先登录~", Toast.LENGTH_SHORT).show();
            accountService.registerObserver(new IAccountService.Observer() {
                @Override
                public void onLoginSuccess() {
                    accountService.unregisterObserver(this);
                    callback.onNext();
                }

                @Override
                public void onLoginCancel() {
                    accountService.unregisterObserver(this);
                    callback.onComplete(CustomUriResult.CODE_LOGIN_CANCEL);
                }

                @Override
                public void onLoginFailure() {
                    accountService.unregisterObserver(this);
                    callback.onComplete(CustomUriResult.CODE_LOGIN_FAILURE);
                }

                @Override
                public void onLogout() {
                    accountService.unregisterObserver(this);
                    callback.onComplete(UriResult.CODE_ERROR);
                }
            });
            ServiceManager.getSingletonKeyService(IAccountService.class).startLogin(request.getContext());
        }
    }
}
