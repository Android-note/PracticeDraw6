package com.hencoder.hencoderpracticedraw6.practice;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;
import com.hencoder.hencoderpracticedraw6.Utils;

import static android.os.Build.VERSION.SDK_INT;
import static com.hencoder.hencoderpracticedraw6.Utils.dpToPixel;

public class Practice01Translation extends RelativeLayout {
    Button animateBt, objectAnimateBt;
    ImageView imageView;
    int translationStatus;
    int translationCount;

    public Practice01Translation(Context context) {
        super(context);
        translationStatus = 0;
        translationCount = 6;
    }

    public Practice01Translation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        translationStatus = 0;
        translationCount = 6;
    }

    public Practice01Translation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        translationStatus = 0;
        translationCount = 6;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        objectAnimateBt = (Button) findViewById(R.id.objectAnimateBt);

        if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            // 给音乐图标加上合适的阴影
            imageView.setOutlineProvider(new MusicOutlineProvider());
        }

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO 在这里处理点击事件，通过 View.animate().translationX/Y/Z() 来让 View 平移
                switch (translationStatus) {
                    case 0:
                        imageView.animate().translationX(Utils.dpToPixel(100));
                        break;
                    case 1:
                        imageView.animate().translationXBy(Utils.dpToPixel(-100));
                        break;
                    case 2:
                        imageView.animate().translationY(Utils.dpToPixel(100));
                        break;
                    case 3:
                        imageView.animate().translationYBy(Utils.dpToPixel(-100));
                        break;
                    case 4:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            imageView.animate().translationZ(Utils.dpToPixel(100));
                        }
                        break;
                    case 5:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            imageView.animate().translationZBy(Utils.dpToPixel(-100));
                        }
                        break;
                }
                translationStatus++;
                if (translationCount == translationStatus) {
                    translationStatus = 0;
                }
            }
        });

        objectAnimateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (translationStatus) {
                    case 0:
                        ObjectAnimator.ofFloat(imageView,
                                "translationX",
                                0,
                                Utils.dpToPixel(100)).start();
                        break;
                    case 1:
                        ObjectAnimator.ofFloat(imageView,
                                "translationX",
                                0).start();
                        break;
                    case 2:
                        ObjectAnimator.ofFloat(imageView,
                                "translationY",
                                0, Utils.dpToPixel(100)).start();
                        break;
                    case 3:
                        ObjectAnimator.ofFloat(imageView,
                                "translationY",
                                0).start();
                        break;
                    case 4:
                        ObjectAnimator.ofFloat(imageView,
                                "translationZ",
                                0, Utils.dpToPixel(100)).start();
                        break;
                    case 5:
                        ObjectAnimator.ofFloat(imageView,
                                "translationZ",
                                0).start();
                        break;
                }
                translationStatus++;
                if (translationCount == translationStatus) {
                    translationStatus = 0;
                }
            }
        });
    }

    /**
     * 为音乐图标设置三角形的 Outline。
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    class MusicOutlineProvider extends ViewOutlineProvider {
        Path path = new Path();

        {
            path.moveTo(0, dpToPixel(10));
            path.lineTo(dpToPixel(7), dpToPixel(2));
            path.lineTo(dpToPixel(116), dpToPixel(58));
            path.lineTo(dpToPixel(116), dpToPixel(70));
            path.lineTo(dpToPixel(7), dpToPixel(128));
            path.lineTo(0, dpToPixel(120));
            path.close();
        }

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setConvexPath(path);
        }
    }
}