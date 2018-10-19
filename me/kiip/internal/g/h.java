package me.kiip.internal.g;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AlphaAnimation;





public class h
{
  public static void a(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(paramFloat);
    } else {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
      localAlphaAnimation.setFillAfter(true);
      paramView.startAnimation(localAlphaAnimation);
    }
  }
}
