package com.foolman.common.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jzj on 2018/3/27.
 */

public class ToastUtils {

    private static Toast sToast;

    public static void showToast(Context context, String text) {
        if (sToast != null) {
            sToast.cancel();
            sToast = null;
        }
        sToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        sToast.show();
    }
}
