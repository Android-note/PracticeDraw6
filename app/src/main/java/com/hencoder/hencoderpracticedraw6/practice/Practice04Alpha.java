package com.hencoder.hencoderpracticedraw6.practice;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice04Alpha extends RelativeLayout {
    Button animateBt, objectAnimateBt;
    ImageView imageView;
    int alphaStatus = 0;
    int alphaCount = 2;

    public Practice04Alpha(Context context) {
        super(context);
    }

    public Practice04Alpha(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04Alpha(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        objectAnimateBt = (Button) findViewById(R.id.objectAnimateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO 在这里处理点击事件，通过 View.animate().alpha() 来改变 View 的透明度
                switch (alphaStatus) {
                    case 0:
                        imageView.animate().alpha(0);
                        break;
                    case 1:
                        imageView.animate().alpha(1);
                        break;
                }
                alphaStatus++;
                if (alphaStatus == alphaCount) {
                    alphaStatus = 0;
                }
            }
        });

        objectAnimateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (alphaStatus) {
                    case 0:
                        ObjectAnimator.ofFloat(imageView,
                                "alpha",
                                0).start();
                        break;
                    case 1:
                        ObjectAnimator.ofFloat(imageView,
                                "alpha",
                                1).start();
                        break;
                }
                alphaStatus++;
                if (alphaStatus == alphaCount) {
                    alphaStatus = 0;
                }
            }
        });
    }
}