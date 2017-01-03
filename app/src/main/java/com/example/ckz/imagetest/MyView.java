package com.example.ckz.imagetest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by CKZ on 2017/1/3.
 */

public class MyView extends View {
    private Bitmap mBitmap;
    private Matrix matrix = new Matrix();
    private float sx = 0.0f;//倾斜度
    private int bitWidth,bitHeight;
    private float scale = 0.1f;//缩放比例

    private int mode = 0;

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void  initView(){
        mBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.sky);
         bitWidth = mBitmap.getWidth();
        bitHeight = mBitmap.getHeight();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        switch (mode){
            case 0:
                matrix.reset();
                break;
            case 1:
                sx+=0.1;
                matrix.setSkew(sx,0);
                break;
            case 2:
                sx-=0.1;
                matrix.setSkew(sx,0);
                break;
            case 3:
                if (scale<2.0){
                    scale+=0.1;
                }
                matrix.setScale(scale,scale);
                break;
            case 4:
                if (scale>0.5){
                    scale-=0.1;
                }
                matrix.setScale(scale,scale);
                break;
        }
        Bitmap bitmap = Bitmap.createBitmap(mBitmap,0,0,bitWidth,bitHeight,matrix,true);
        canvas.drawBitmap(bitmap,matrix,null);
    }

    public void setMode(int i){
        mode = i;
        postInvalidate();
    }
}
