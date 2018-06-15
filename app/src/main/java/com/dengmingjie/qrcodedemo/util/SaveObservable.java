package com.dengmingjie.qrcodedemo.util;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: dengmingjie
 * Date: 2018.05.25 17:45 星期五
 * Email: mjdeng@1015shop.com
 * Desc:
 */
public class SaveObservable implements Observable.OnSubscribe<String> {

    private Bitmap drawingCache = null;

    public SaveObservable(Bitmap drawingCache) {
        this.drawingCache = drawingCache;
    }

    @Override
    public void call(Subscriber<? super String> subscriber) {
        if (drawingCache == null) {
            subscriber.onError(new NullPointerException("获取ImageView的Bitmap为null，请确认ImageView显示图片了！"));
        } else {
            try {
                String sdcard = Environment.getExternalStorageDirectory().toString();
                File file = new File(sdcard + "/Pictures");
                if (!file.exists()) {
                    file.mkdirs();
                }

                File imageFile = new File(file.getAbsolutePath(),"QRCode_" + new Date().getTime()+".jpg");
                FileOutputStream outStream = new FileOutputStream(imageFile);
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
                subscriber.onNext(imageFile.getPath());
                subscriber.onCompleted();
                outStream.flush();
                outStream.close();
            } catch (IOException e) {
                subscriber.onError(e);
            }
        }
    }
}
