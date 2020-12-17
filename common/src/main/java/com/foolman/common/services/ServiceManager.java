package com.foolman.common.services;

import com.foolman.common.constants.Constant;
import com.sankuai.waimai.router.Router;

/**
 * Created by jzj on 2018/4/19.
 */

public class ServiceManager {

    public static <I, T extends I> T getSingletonKeyService(Class<I> clazz) {
        return Router.getService(clazz, Constant.SINGLETON);
    }
}
