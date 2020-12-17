package com.foolman.test.ab;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.foolman.testapi.constants.Constant;
import com.sankuai.waimai.router.activity.AbsActivityHandler;
import com.sankuai.waimai.router.annotation.RouterUri;
import com.sankuai.waimai.router.core.UriRequest;

@RouterUri(path = Constant.HOME_AB_TEST)
public class HomeABTestHandler extends AbsActivityHandler {

    @NonNull
    @Override
    protected Intent createIntent(@NonNull UriRequest request) {
        if (FakeABTestService.getHomeABStrategy().equals("A")) {
            return new Intent(request.getContext(), HomeActivityA.class);
        } else {
            return new Intent(request.getContext(), HomeActivityB.class);
        }
    }
}
