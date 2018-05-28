package com.dengmingjie.qrcodedemo.util;

import android.util.Log;
import android.widget.Toast;

import rx.Subscriber;

/**
 * Author: dengmingjie
 * Date: 2018.05.25 17:46 星期五
 * Email: mjdeng@1015shop.com
 * Desc:
 */
public class SaveSubscriber extends Subscriber<String> {

    @Override
    public void onCompleted() {
        //Toast.makeText(Utils.getContext(), "保存成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Throwable e) {
        Log.i(getClass().getSimpleName(), e.toString());
        Toast.makeText(Utils.getContext(), "保存失败，" + e.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(String s) {
        Toast.makeText(Utils.getContext(), "保存至" + s, Toast.LENGTH_SHORT).show();
    }
}

