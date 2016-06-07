package be.myitworld.fragmentsample.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import be.myitworld.fragmentsample.R;

/**
 * Created by Jorciney on 07/06/2016.
 */
public class SplashScreen extends Activity{
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);
        startAnimations();

        Thread timerThread= new Thread(){
          public void run(){
              try{
                  sleep(2500);
              }catch (InterruptedException e){
                  e.printStackTrace();
              }
              finally {
                  Intent intent=new Intent(SplashScreen.this,MainActivity.class);

                  startActivity(intent);
                  overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
              }
          }
        };
        timerThread.start();
    }

    private void startAnimations() {
        Animation anim= AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        RelativeLayout l=(RelativeLayout) findViewById(R.id.splash_linear_layout);
        l.clearAnimation();
        l.startAnimation(anim);

        anim=AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        TextView text=(TextView)findViewById(R.id.splash_text);
        text.clearAnimation();
        text.startAnimation(anim);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public void onAttachedToWindow(){
        super.onAttachedToWindow();
        Window window=getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }


}
