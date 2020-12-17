package com.sankuai.waimai.router.demo.kotlin

import com.foolman.demokotlinapi.Constant
import com.sankuai.waimai.router.annotation.RouterService

@RouterService(interfaces = [Object::class], key = [Constant.KOTLIN_SERVICE])
class KotlinService {

}