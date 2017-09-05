package br.com.brunograss.mflow;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.race604.drawable.wave.WaveDrawable;

public class SplashActivity extends AppCompatActivity implements Runnable {

    private final int TIME_DURATION = 3000;
    private ImageView mImageView;
    private WaveDrawable mWaveDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mImageView = (ImageView) findViewById(R.id.image);
        mWaveDrawable = new WaveDrawable(this, R.drawable.splash_loading);
        mImageView.setImageDrawable(mWaveDrawable);

        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.setDuration(TIME_DURATION);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        mWaveDrawable.setIndeterminateAnimator(animator);
        mWaveDrawable.setIndeterminate(true);

        Handler handler = new Handler();
        handler.postDelayed(this, TIME_DURATION);

    }

    @Override
    public void run() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
