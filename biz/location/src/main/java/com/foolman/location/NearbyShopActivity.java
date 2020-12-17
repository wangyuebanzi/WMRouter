package com.foolman.location;

import com.foolman.common.BaseActivity;
import com.foolman.locationapi.constants.Constant;
import com.sankuai.waimai.router.annotation.RouterUri;

/**
 * 附近商家，需要先定位
 * <p>
 * Created by jzj on 2018/3/26.
 */
@RouterUri(path = Constant.NEARBY_SHOP_WITH_LOCATION_INTERCEPTOR,
        interceptors = LocationInterceptor.class)
public class NearbyShopActivity extends BaseActivity {

}
