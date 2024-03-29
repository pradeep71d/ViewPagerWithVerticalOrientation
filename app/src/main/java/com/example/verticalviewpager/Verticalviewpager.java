package com.example.verticalviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.viewpager.widget.ViewPager;

public class Verticalviewpager extends ViewPager {
    public Verticalviewpager(@NonNull Context context) {
        super(context);
        init();
    }

    public Verticalviewpager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init(){
        setPageTransformer(true,new VerticalPage());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private void setPageTransformer(boolean b) {
    }
    private MotionEvent getIntercamioXY(MotionEvent ev){
float width=getWidth();
float height=getHeight();
float newX=(ev.getY()/height)*width;
float newY=(ev.getX()/width)*height;
ev.setLocation(newX,newY);
return ev;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted= super.onInterceptTouchEvent(getIntercamioXY(ev));
        getIntercamioXY(ev);
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(getIntercamioXY(ev));
    }
    private class VerticalPage implements ViewPager.PageTransformer{

        @Override
        public void transformPage(@NonNull View page, float position) {
            if (position<-1){
                page.setAlpha(0);
            }else if (position<=1){
                page.setAlpha(1);
                page.setTranslationX(page.getWidth()*-position);
                float yPosition=position*page.getHeight();
                page.setTranslationY(yPosition);

            }else {
                page.setAlpha(0);
            }
        }
    }
}
