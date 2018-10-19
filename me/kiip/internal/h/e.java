package me.kiip.internal.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;


public final class e
  extends RelativeLayout
{
  private RotateAnimation a;
  private AlphaAnimation b;
  private AlphaAnimation c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private TextView g;
  
  public e(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a() {
    Context localContext = getContext();
    
    a = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    a.setDuration(1000L);
    a.setInterpolator(new LinearInterpolator());
    a.setRepeatCount(-1);
    a.setRepeatMode(-1);
    
    b = new AlphaAnimation(0.0F, 1.0F);
    b.setDuration(300L);
    b.setFillAfter(true);
    c = new AlphaAnimation(1.0F, 0.0F);
    c.setDuration(300L);
    c.setFillAfter(true);
    
    d = new ImageView(localContext);
    e = new TextView(localContext);
    f = new TextView(localContext);
    g = new TextView(localContext);
    
    addView(d);
    addView(e);
    addView(f);
    addView(g);
    
    b();
  }
  
  private void b() {
    Context localContext = getContext();
    Resources localResources = localContext.getResources();
    float f1 = getDisplayMetricsdensity;
    
    setPadding((int)(17.0F * f1), (int)(17.0F * f1), (int)(17.0F * f1), (int)(17.0F * f1));
    setBackgroundColor(Color.parseColor("#E6000000"));
    


    int i = localResources.getIdentifier("kp_activity_indicator", "drawable", localContext.getPackageName());
    Drawable localDrawable = null;
    if (i > 0) {
      localDrawable = localContext.getResources().getDrawable(i);
    } else {
      Log.w("KiipSDK", "Unable to find kp_activity_indicator.png in drawable-*");
    }
    
    d.setId(1);
    d.setImageDrawable(localDrawable);
    
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    leftMargin = ((int)(17.0F * f1));
    localLayoutParams.addRule(1, 1);
    
    e.setLayoutParams(localLayoutParams);
    e.setEllipsize(TextUtils.TruncateAt.END);
    e.setSingleLine();
    e.setTextColor(-1);
    e.setTextSize(12.0F);
    
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    leftMargin = ((int)(17.0F * f1));
    localLayoutParams.addRule(1, 1);
    localLayoutParams.addRule(8, 1);
    
    f.setLayoutParams(localLayoutParams);
    f.setEllipsize(TextUtils.TruncateAt.END);
    f.setSingleLine();
    f.setTextColor(-1);
    f.setTextSize(12.0F);
    
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    leftMargin = ((int)(17.0F * f1));
    localLayoutParams.addRule(1, 1);
    localLayoutParams.addRule(15);
    
    g.setLayoutParams(localLayoutParams);
    g.setEllipsize(TextUtils.TruncateAt.END);
    g.setSingleLine();
    g.setText("Tap again to cancel");
    g.setTextColor(-1);
    g.setTextSize(12.0F);
    g.setVisibility(4);
  }
  
  public void setTitle(String title) {
    e.setText(title);
  }
  
  public void setMessage(String message) {
    f.setText(message);
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      g.setVisibility(0);
      e.startAnimation(c);
      f.startAnimation(c);
      g.startAnimation(b);
    } else {
      e.startAnimation(b);
      f.startAnimation(b);
      g.startAnimation(c);
    }
  }
  
  public void setVisibility(int v)
  {
    if (getVisibility() != v) {
      super.setVisibility(v);
      

      if ((v == 8) || (v == 4)) {
        d();
      } else {
        c();
      }
    }
  }
  
  protected void onVisibilityChanged(View changedView, int visibility)
  {
    super.onVisibilityChanged(changedView, visibility);
    

    if ((visibility == 8) || (visibility == 4)) {
      d();
    } else {
      c();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    c();
  }
  
  protected void onDetachedFromWindow()
  {
    d();
    super.onDetachedFromWindow();
  }
  
  private void c() {
    d.startAnimation(a);
  }
  
  private void d() {
    d.clearAnimation();
  }
}
