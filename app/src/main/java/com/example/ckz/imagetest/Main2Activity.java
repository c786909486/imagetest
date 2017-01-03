package com.example.ckz.imagetest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    private ImageView img_meizi;
    private EditText edit_mul;
    private EditText edit_add;
    private Button btn_change , btn_baocun;
    private Bitmap mBitmap;
    private Bitmap afBitmap;

    private int mul ,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.sky);
        bindViews();
    }
    private void bindViews() {
        img_meizi = (ImageView) findViewById(R.id.img_meizi);
        edit_mul = (EditText) findViewById(R.id.edit_mul);
        edit_add = (EditText) findViewById(R.id.edit_add);
        btn_change = (Button) findViewById(R.id.btn_change);
        btn_baocun = (Button) findViewById(R.id.btn_baocun);

        btn_change.setOnClickListener(this);
        btn_baocun.setOnClickListener(this);

    }
    private Bitmap ProcessImage(Bitmap bmp,int mul,int add){
        Bitmap bitmap = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColorFilter(new LightingColorFilter(mul,add));
        canvas.drawBitmap(bmp,0,0,paint);
        return bitmap;
    }
    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.btn_change:
               mul = Integer.valueOf(edit_mul.getText().toString());
                add = Integer.valueOf(edit_add.getText().toString());
               img_meizi.setImageBitmap(ProcessImage(mBitmap,mul,add) );
               break;
           case R.id.btn_baocun:
               mul = Integer.valueOf(edit_mul.getText().toString());
               add = Integer.valueOf(edit_add.getText().toString());
               afBitmap = ProcessImage(mBitmap,mul,add);
               FileUntils.saveBitmap(this,afBitmap);
               break;
       }
    }
}
