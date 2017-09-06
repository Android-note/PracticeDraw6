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

public class Practice03Scale extends RelativeLayout {
    Button animateBt, objectAnimateBt;
    ImageView imageView;
    int scaleStatus;
    int scaleCount;

    public Practice03Scale(Context context) {
        super(context);
        scaleStatus = 0;
        scaleCount = 4;
    }

    public Practice03Scale(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        scaleStatus = 0;
        scaleCount = 4;
    }

    public Practice03Scale(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scaleStatus = 0;
        scaleCount = 4;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        objectAnimateBt = (Button) findViewById(R.id.objectAnimateBt);

        animateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO 在这里处理点击事件，通过 View.animate().scaleX/Y() 来让 View 放缩
                switch (scaleStatus) {
                    case 0:
                        imageView.animate().scaleX(1.5f);
                        break;
                    case 1:
                        imageView.animate().scaleX(1);
                        break;
                    case 2:
                        imageView.animate().scaleY(1.5f);
                        break;
                    case 3:
                        imageView.animate().scaleY(1);
                        break;
                }
                scaleStatus++;
                if (scaleStatus == scaleCount) {
                    scaleStatus = 1;
                }
            }
        });

        objectAnimateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (scaleStatus) {
                    case 0:
                        ObjectAnimator.ofFloat(imageView,
                                "scaleX",
                                1.5f).start();
                        break;
                    case 1:
                        ObjectAnimator.ofFloat(imageView,
                                "scaleX",
                                1).start();
                        break;
                    case 2:
                        ObjectAnimator.ofFloat(imageView,
                                "scaleY",
                                1.5f).start();
                        break;
                    case 3:
                        ObjectAnimator.ofFloat(imageView,
                                "scaleY",
                                1).start();
                        break;
                }
                scaleStatus++;
                if (scaleStatus == scaleCount) {
                    scaleStatus = 0;
                }
            }
        });
    }
}
