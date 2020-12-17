package com.foolman.test.annotation;

import com.foolman.testapi.constants.Path;
import com.sankuai.waimai.router.annotation.RouterPage;
import com.sankuai.waimai.router.common.UriParamInterceptor;
import com.sankuai.waimai.router.core.ChainedInterceptor;
import com.sankuai.waimai.router.core.UriHandler;

/**
 * 测试Page注解生成器
 * <p>
 * Created by jzj on 2018/3/23.
 */
public class TestPageAnnotation {

    @RouterPage(path = Path.TEST_HANDLER)
    public static class TestHandler extends EmptyHandler {

    }

    @RouterPage(path = Path.TEST_INTERCEPTOR, interceptors = UriParamInterceptor.class)
    public static class TestInterceptorHandler extends EmptyHandler {

    }

    @RouterPage(path = Path.TEST_INTERCEPTORS, interceptors = {UriParamInterceptor.class, ChainedInterceptor.class})
    public static class TestInterceptorsHandler extends EmptyHandler {

    }

    @RouterPage(path = Path.TEST_ABSTRACT)
    public static abstract class AbstractHandler extends UriHandler {

    }

    @RouterPage(path = Path.TEST_CLASS)
    public static class NormalClass {

    }
}
