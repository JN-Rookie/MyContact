package edu.feicui.mycontact.main;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import edu.feicui.mycontact.R;

public class MainActivity extends AppCompatActivity {

    private ImageView mIv_show;
    private Animation mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIv_show = (ImageView) findViewById(R.id.iv_logo);
        mIv_show.setBackgroundResource(R.drawable.frame);
        AnimationDrawable mAnimationDrawable = (AnimationDrawable) mIv_show.getBackground();

        mAnimationDrawable.start();
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,TelmsgActivity.class);
                startActivity(intent);
                finish();
            }
        },2500);
////        初始控件和动画
//
//        mAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
//        Animation.AnimationListener mAnimationListener = new Animation.AnimationListener() {
//            @Override
//            //        动画开始
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            //      动画结束
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                Intent intent = new Intent(MainActivity.this, TelmsgActivity.class);
//                startActivity(intent);
//                finish();
//            }
//
//            //动画重复
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        };
//        mAnimation.setAnimationListener(mAnimationListener);
//        mIv_show.startAnimation(mAnimation);
//    }

    }
}
