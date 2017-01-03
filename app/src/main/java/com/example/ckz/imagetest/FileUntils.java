package com.example.ckz.imagetest;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by CKZ on 2017/1/3.
 */

public class FileUntils {
    public static File saveBitmap(Bitmap bitmap){
        File appDir = new File(Environment.getExternalStorageDirectory(), "ImageHee");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = "Cache_" + System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            Log.d("Save","图片已保存到"+appDir);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
