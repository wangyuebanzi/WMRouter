package com.foolman.test.page;

import android.support.v4.app.Fragment;

import com.foolman.testapi.constants.Constant;
import com.sankuai.waimai.router.annotation.RouterService;

/**
 * Created by jzj on 2018/4/19.
 */
@RouterService(interfaces = Fragment.class, key = Constant.TEST_FRAGMENT)
public class TestFragment extends Fragment {

}
