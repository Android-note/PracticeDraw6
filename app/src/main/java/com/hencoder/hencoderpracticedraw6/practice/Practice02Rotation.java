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

public class Practice02Rotation extends RelativeLayout {
    Button animateBt, objectAnimateBt;
    ImageView imageView;
    int rotationStatus;
    int rotationCount;

    public Practice02Rotation(Context context) {
        super(context);
        rotationStatus = 0;
        rotationCount = 6;
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        rotationStatus = 0;
        rotationCount = 6;
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        rotationStatus = 0;
        rotationCount = 6;
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
                // // TODO 在这里处理点击事件，通过 View.animate().rotation/X/Y() 来让 View 旋转
                switch (rotationStatus) {
                    case 0:
                        imageView.animate().rotationX(180);
                        break;
                    case 1:
                        imageView.animate().rotationX(0);
                        break;
                    case 2:
                        imageView.animate().rotationY(180);
                        break;
                    case 3:
                        imageView.animate().rotationY(0);
                        break;
                    case 4:
                        imageView.animate().rotation(180);
                        break;
                    case 5:
                        imageView.animate().rotation(0);
                        break;
                }
                rotationStatus++;
                if (rotationCount == rotationStatus) {
                    rotationStatus = 0;
                }
            }
        });

        objectAnimateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rotationStatus) {
                    case 0:
                        ObjectAnimator.ofFloat(imageView,
                                "rotationX",
                                0,
                                180).start();
                        break;
                    case 1:
                        ObjectAnimator.ofFloat(imageView,
                                "rotationX",
                                0).start();
                        break;
                    case 2:
                        ObjectAnimator.ofFloat(imageView,
                                "rotationY",
                                0,
                                180).start();
                        break;
                    case 3:
                        ObjectAnimator.ofFloat(imageView,
                                "rotationY",
                                0).start();
                        break;
                    case 4:
                        ObjectAnimator.ofFloat(imageView,
                                "rotation",
                                180).start();
                        break;
                    case 5:
                        ObjectAnimator.ofFloat(imageView,
                                "rotation",
                                0).start();
                        break;
                }
                rotationStatus++;
                if (rotationStatus == rotationCount) {
                    rotationStatus = 0;
                }
            }
        });
    }
}