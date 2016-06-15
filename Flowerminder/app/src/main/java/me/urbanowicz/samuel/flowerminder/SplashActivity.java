package me.urbanowicz.samuel.flowerminder;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

import me.urbanowicz.samuel.flowerminder.flowers.FlowersActivity;

import static com.google.common.base.Preconditions.checkNotNull;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        View content = findViewById(R.id.splash_content);
        checkNotNull(content);

        AlphaAnimation alphaAnimation = new AlphaAnimation(1.f, 0.f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                content.setVisibility(View.GONE);
                startActivity(new Intent(SplashActivity.this, FlowersActivity.class));
                finish();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        alphaAnimation.setInterpolator(new DecelerateInterpolator());

        Handler handler = new Handler();
        handler.postDelayed(() -> content.startAnimation(alphaAnimation), 1500);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
