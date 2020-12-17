package com.foolman.web;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.foolman.common.constants.Constant;
import com.sankuai.waimai.router.Router;
import com.sankuai.waimai.router.core.UriCallback;
import com.sankuai.waimai.router.core.UriInterceptor;
import com.sankuai.waimai.router.core.UriRequest;
import com.sankuai.waimai.router.utils.RouterUtils;

import java.util.HashMap;

/**
 * 给URL添加共通参数
 * <p>
 * Created by jzj on 2018/3/27.
 */

public class CommonParamInterceptor implements UriInterceptor {

    private HashMap<String, String> mCommonParams;

    @Override
    public void intercept(@NonNull UriRequest request, @NonNull UriCallback callback) {
        initIfNeeded();
        Uri uri = RouterUtils.appendParams(request.getUri(), mCommonParams);
        request.setUri(uri);
        callback.onNext();
    }

    private void initIfNeeded() {
        if (mCommonParams == null) {
            mCommonParams = new HashMap<>();
            mCommonParams.put("platform", "android");
            mCommonParams.put("version",
                    String.valueOf((int) Router.callMethod(Constant.GET_VERSION_CODE)));
        }
    }
}
