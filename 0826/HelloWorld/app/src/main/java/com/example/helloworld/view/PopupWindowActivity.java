package com.example.helloworld.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class PopupWindowActivity extends AppCompatActivity{

    private Button btn_show;
    private Context mContext;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow_layout);
        mContext=this;
        btn_show=(Button) findViewById(R.id.btn_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopWindow(v);
            }
        });
    }

    public void initPopWindow(View v){
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_popup,null,false);
        Button btn_xixi = (Button) view.findViewById(R.id.btn_xixi);
        Button btn_hehe = (Button) view.findViewById(R.id.btn_hehe);

        //1.构造一个PopupWindow，参数依次是加载的View，宽高
        final PopupWindow popupWindow = new PopupWindow(view,ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,true);

        popupWindow.setAnimationStyle(R.anim.anim_pop);

        /*
        这些为了点击非PopupWindow的区域时，PopupWindow窗口会消失，否则窗口不会关闭
        */
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
                //如果这里返回true，touch事件将被拦截，无法调用popupWindow的 onTouchEvent方法，
                //点击外部区域则无法dismiss
            }
        });

        //设置popupWindow显示的位置，参数依次是：参照物view，x偏移量，y偏移量
        popupWindow.showAsDropDown(v,100,100);

        //设置popupWindow 里的按钮事件
        btn_xixi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"你点击了呵呵~",Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
    }
}
