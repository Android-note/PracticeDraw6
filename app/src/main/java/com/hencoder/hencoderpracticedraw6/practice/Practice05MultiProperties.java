package com.hencoder.hencoderpracticedraw6.practice;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hencoder.hencoderpracticedraw6.R;
import com.hencoder.hencoderpracticedraw6.Utils;

public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt, objectAnimateBt;
    ImageView imageView;
    int multiPropertiesStatus = 0;
    int multiPropertiesCount = 2;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        objectAnimateBt = (Button) findViewById(R.id.objectAnimateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，同时对多个属性做动画

                switch (multiPropertiesStatus) {
                    case 0:
                        imageView.animate()
                                .scaleX(1)
                                .scaleY(1)
                                .rotation(360)
                                .alpha(1)
                                .translationX(Utils.dpToPixel(200));
                        break;
                    case 1:
                        imageView.animate()
                                .scaleX(0)
                                .scaleY(0)
                                .rotation(0)
                                .alpha(0)
                                .translationX(0);
                        break;
                }

                multiPropertiesStatus++;
                if (multiPropertiesStatus == multiPropertiesCount) {
                    multiPropertiesStatus = 0;
                }
            }
        });

        objectAnimateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (multiPropertiesStatus) {
                    case 0:
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(
                                ObjectAnimator.ofFloat(
                                        imageView,
                                        "scaleX",
                                        1
                                ),
                                ObjectAnimator.ofFloat(
                                        imageView,
                                        "scaleY",
                                        1
                                ),
                                ObjectAnimator.ofFloat(
                                        imageView,
                                        "rotation",
                                        360
                                ),
                                ObjectAnimator.ofFloat(
                                        imageView,
                                        "alpha",
                                        1
                                ),
                                ObjectAnimator.ofFloat(
                                        imageView,
                                        "translationX",
                                        Utils.dpToPixel(200)
                                )
                        );
                        animatorSet.start();
                        break;
                    case 1:
                        AnimatorSet animatorSet1 = new AnimatorSet();
                        animatorSet1.playTogether(
                                ObjectAnimator.ofFloat(
                                        imageView,
                                        "scaleX",
                                        0
                                ),
                                ObjectAnimator.ofFloat(
                                        imageView,
                                        "scaleY",
                                        0
                                ),
                                ObjectAnimator.ofFloat(
                                        imageView,
                                        "rotation",
                                        0
                                ),
                                ObjectAnimator.ofFloat(
                                        imageView,
                                        "alpha",
                                        0
                                ),
                                ObjectAnimator.ofFloat(
                                        imageView,
                                        "translationX",
                                        0
                                )
                        );
                        animatorSet1.start();
                        break;
                }

                multiPropertiesStatus++;
                if (multiPropertiesStatus == multiPropertiesCount) {
                    multiPropertiesStatus = 0;
                }
            }
        });

    }
}
