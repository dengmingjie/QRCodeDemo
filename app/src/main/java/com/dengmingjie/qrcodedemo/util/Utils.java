package com.dengmingjie.qrcodedemo.util;

import android.content.Context;

/**
 * Author: dengmingjie
 * Date: 2018.02.09 18:17 星期五
 * Email: mjdeng@1015shop.com
 * Desc: Utils初始化类
 */

public class Utils {

    private static Context context;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        Utils.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) return context;
        throw new NullPointerException("u should init first");
    }
}