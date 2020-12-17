package com.foolman.test.page;

import com.foolman.common.BaseActivity;
import com.foolman.testapi.constants.Constant;
import com.sankuai.waimai.router.annotation.RouterUri;

/**
 * Created by jzj on 2018/3/26.
 */
@RouterUri(
        scheme = Constant.DEMO_SCHEME,
        host = Constant.DEMO_HOST,
        path = Constant.EXPORTED_PATH,
        exported = true
)
public class ExportedActivity extends BaseActivity {

}
