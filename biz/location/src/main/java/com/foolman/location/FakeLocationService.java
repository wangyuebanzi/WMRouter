package com.foolman.location;

import android.os.Handler;

import com.foolman.common.constants.Constant;
import com.foolman.locationapi.ILocationService;
import com.sankuai.waimai.router.annotation.RouterService;

/**
 * Created by jzj on 2018/3/26.
 */
@RouterService(interfaces = ILocationService.class, key = Constant.SINGLETON, singleton = true)
public class FakeLocationService implements ILocationService {

    private final Handler mHandler = new Handler();

    @Override
    public boolean hasLocation() {
        return false;
    }

    @Override
    public void startLocation(final LocationListener listener) {
        if (listener != null) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    listener.onSuccess();
                }
            }, 800);
        }
    }
}
