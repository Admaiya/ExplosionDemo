package definition;

import particle.Particle;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import factory.ParticleFactory;

/**
 * Created by Administrator on 2015/11/28 0028.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ExplosionAnimator extends ValueAnimator {
    public static final int DEFAULT_DURATION = 0x400;
    private Particle[][] mParticles;
    private Paint mPaint;
    private View mContainer;
    private ParticleFactory mParticleFactory;

    public ExplosionAnimator(View view, Bitmap bitmap, Rect bound,ParticleFactory particleFactory) {
        mParticleFactory = particleFactory;
        mPaint = new Paint();
        mContainer = view;
        setFloatValues(0.0f, 1.0f);
        setDuration(DEFAULT_DURATION);
        mParticles = mParticleFactory.generateParticles(bitmap, bound);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	public void draw(Canvas canvas) {
        if(!isStarted()) { //动画结束时停止
            return;
        }
        //所有粒子运动
        for (Particle[] particle : mParticles) {
            for (Particle p : particle) {
                p.advance(canvas,mPaint,(Float) getAnimatedValue());
            }
        }
        mContainer.invalidate();
    }

    @Override
    public void start() {
        super.start();
        mContainer.invalidate();
    }
}
