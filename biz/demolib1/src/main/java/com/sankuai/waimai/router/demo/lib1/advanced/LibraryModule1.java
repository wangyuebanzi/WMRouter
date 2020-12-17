package com.sankuai.waimai.router.demo.lib1.advanced;

import com.foolman.common.services.LibraryModule;
import com.sankuai.waimai.router.annotation.RouterService;

/**
 * Created by jzj on 2018/4/19.
 */
@RouterService(interfaces = LibraryModule.class)
public class LibraryModule1 extends LibraryModule {

    @Override
    public String getModuleName() {
        return "lib1";
    }
}
