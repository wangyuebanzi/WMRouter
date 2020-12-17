package com.sankuai.waimai.router.demo.kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import com.foolman.demokotlinapi.Constant
import com.sankuai.waimai.router.Router
import com.sankuai.waimai.router.annotation.RouterUri

@RouterUri(path = [Constant.KOTLIN])
class KotlinActivity : com.foolman.common.BaseActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val a = Router.callMethod(com.foolman.common.constants.Constant.ADD_METHOD, 2, 3) as Int
        val txt = TextView(this)
        txt.text = "Kotlin模块调用Java模块的Service：\n2 + 3 = " + a.toString()
        setContentView(txt)
    }
}