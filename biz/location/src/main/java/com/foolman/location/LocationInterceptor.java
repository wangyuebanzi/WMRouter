package com.foolman.location;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.foolman.common.constants.Constant;
import com.foolman.common.util.CustomUriResult;
import com.foolman.common.util.DialogUtils;
import com.foolman.common.util.ToastUtils;
import com.foolman.locationapi.ILocationService;
import com.sankuai.waimai.router.Router;
import com.sankuai.waimai.router.core.UriCallback;
import com.sankuai.waimai.router.core.UriInterceptor;
import com.sankuai.waimai.router.core.UriRequest;

/**
 * 用于定位的Interceptor
 * <p>
 * Created by jzj on 2018/3/23.
 */

public class LocationInterceptor implements UriInterceptor {

    @Override
    public void intercept(@NonNull final UriRequest request, @NonNull final UriCallback callback) {
        ILocationService locationService = Router.getService(ILocationService.class, Constant.SINGLETON);
        if (locationService.hasLocation()) {
            // 已有定位信息，不做拦截，继续跳转
            callback.onNext();
            return;
        }
        final Context context = request.getContext();
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            // 异常情况，忽略
            callback.onNext();
            return;
        }
        final ProgressDialog dialog = DialogUtils.showProgress(context, "定位中...");
        locationService.startLocation(new ILocationService.LocationListener() {
            @Override
            public void onSuccess() {
                // 定位成功，继续跳转
                ToastUtils.showToast(context, "定位成功");
                DialogUtils.dismiss(dialog);
                callback.onNext();
            }

            @Override
            public void onFailure() {
                // 定位失败，不跳转
                ToastUtils.showToast(context, "定位失败");
                DialogUtils.dismiss(dialog);
                callback.onComplete(CustomUriResult.CODE_LOCATION_FAILURE);
            }
        });
    }
}
