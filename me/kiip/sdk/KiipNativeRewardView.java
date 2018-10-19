package me.kiip.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import me.kiip.internal.e.g;
import me.kiip.internal.h.c;
import me.kiip.internal.h.c.a;
import me.kiip.internal.h.e;

public class KiipNativeRewardView extends RelativeLayout
{
  private static final String a = KiipNativeRewardView.class.getName();
  

  private Handler b;
  

  private c c;
  

  private e d;
  
  private ImageView e;
  
  private ImageButton f;
  
  private VideoView g;
  
  private HashMap<String, String> h;
  
  private Runnable i;
  
  private Runnable j;
  
  private OnShowListener k;
  
  private Kiip.OnContentListener l;
  
  private boolean m;
  
  private RewardViewType n = RewardViewType.MEDIUM_RECTANGLE;
  private boolean o;
  
  public KiipNativeRewardView(Context context) { this(context, null); }
  
  public KiipNativeRewardView(Context context, AttributeSet attrs)
  {
    this(context, attrs, 0);
  }
  
  public KiipNativeRewardView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    a(context);
  }
  

  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
  {
    int i1 = widthMeasureSpec;
    int i2 = heightMeasureSpec;
    float f1 = getResourcesgetDisplayMetricsdensity;
    
    if (n.equals(RewardViewType.FLUID_RECTANGLE)) {
      i2 = View.MeasureSpec.makeMeasureSpec((int)(320.0F * f1 + 0.5F), 1073741824);
      i1 = widthMeasureSpec;
    } else if (n.equals(RewardViewType.MEDIUM_RECTANGLE)) {
      i1 = View.MeasureSpec.makeMeasureSpec((int)(300.0F * f1 + 0.5F), 1073741824);
      i2 = View.MeasureSpec.makeMeasureSpec((int)(250.0F * f1 + 0.5F), 1073741824);
    }
    
    super.onMeasure(i1, i2);
    setMeasuredDimension(i1, i2);
  }
  


  private Runnable p = new Runnable()
  {
    public void run() {
      KiipNativeRewardView.a(KiipNativeRewardView.this);
    }
  };
  private Runnable q = new Runnable()
  {
    public void run() {
      KiipNativeRewardView.a(KiipNativeRewardView.this, false);
    }
  };
  
  private View.OnClickListener r = new View.OnClickListener()
  {
    public void onClick(View v) {
      if (!KiipNativeRewardView.b(KiipNativeRewardView.this))
      {

        KiipNativeRewardView.a(KiipNativeRewardView.this, true);
        KiipNativeRewardView.d(KiipNativeRewardView.this).postDelayed(KiipNativeRewardView.c(KiipNativeRewardView.this), 3000L);
      }
    }
  };
  
  private void a() {
    d.setVisibility(0);
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean) {
      o = true;
    } else {
      o = false;
    }
    d.a(paramBoolean);
  }
  
  public void cancelReward() {
    b.removeCallbacks(p);
    b.removeCallbacks(q);
    try
    {
      c.stopLoading();
    }
    catch (NullPointerException localNullPointerException) {}
  }
  

  private c.a s = new c.a()
  {
    public void a() {
      if (KiipNativeRewardView.e(KiipNativeRewardView.this) != null) {
        KiipNativeRewardView.e(KiipNativeRewardView.this).run();
      }
    }
    
    public void b()
    {
      KiipNativeRewardView.b(KiipNativeRewardView.this, true);
      if (KiipNativeRewardView.f(KiipNativeRewardView.this) != null) {
        KiipNativeRewardView.f(KiipNativeRewardView.this).run();
      }
    }
    

    public void a(boolean paramAnonymousBoolean) {}
  };
  

  private void a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i1 = localResources.getIdentifier("kp_play_video", "drawable", paramContext.getPackageName());
    int i2 = localResources.getIdentifier("kp_cancel_video", "drawable", paramContext.getPackageName());
    if ((i1 <= 0) || (i2 <= 0)) {
      android.util.Log.w("KiipSDK", "Unable to find kp_play_video.png or kp_cancel_video in drawable-*");
    }
    

    h = new HashMap();
    b = new Handler();
    
    e = new ImageView(paramContext);
    f = new ImageButton(paramContext);
    e.setImageResource(i1);
    f.setImageResource(i2);
    d = new e(paramContext);
    
    g = new VideoView(getContext())
    {
      public boolean canSeekForward()
      {
        return false;
      }
      
      public boolean canSeekBackward() {
        return true;
      }
      
      public boolean canPause() {
        return true;
      }
      


      public boolean onTouchEvent(MotionEvent mv)
      {
        if ((mv.getAction() == 0) && (isPlaying())) {
          KiipNativeRewardView.g(KiipNativeRewardView.this).setVisibility(0);
          
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
          localAlphaAnimation.setDuration(2000L);
          localAlphaAnimation.setRepeatCount(0);
          localAlphaAnimation.setRepeatMode(2);
          localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public void onAnimationStart(Animation animation) {}
            


            public void onAnimationEnd(Animation animation)
            {
              KiipNativeRewardView.g(KiipNativeRewardView.this).setVisibility(8);
            }
            



            public void onAnimationRepeat(Animation animation) {}
          });
          KiipNativeRewardView.g(KiipNativeRewardView.this).startAnimation(localAlphaAnimation);
          pause();
        }
        else if ((!isPlaying()) && (mv.getAction() == 0)) {
          KiipNativeRewardView.g(KiipNativeRewardView.this).setVisibility(8);
          seekTo(getCurrentPosition());
          start();
        }
        return true;
      }
    };
    g.setId(Integer.valueOf(5).intValue());
    c = new c(paramContext, g, f);
    
    addView(d, new RelativeLayout.LayoutParams(-2, -2) {});
    addView(c, new RelativeLayout.LayoutParams(-1, -1));
    
    addView(g, new RelativeLayout.LayoutParams(-1, -1) {});
    addView(e, new RelativeLayout.LayoutParams(-2, -2) {});
    addView(f, new RelativeLayout.LayoutParams(-2, -2) {});
    setupViews(paramContext);
  }
  
  private void setupViews(Context context)
  {
    g.setVisibility(4);
    e.setVisibility(4);
    f.setVisibility(4);
    
    d.setVisibility(4);
    d.setOnClickListener(r);
    
    c.setVisibility(4);
    
    if (Build.VERSION.SDK_INT >= 19) {
      c.setWebContentsDebuggingEnabled(true);
    }
    
    c.setOnShowURLListener(new me.kiip.internal.h.c.b()
    {

      public void a(boolean paramAnonymousBoolean) {}


    });
    c.setOnJSListener(new c.a()
    {
      public void a()
      {
        KiipNativeRewardView.d(KiipNativeRewardView.this).removeCallbacks(KiipNativeRewardView.h(KiipNativeRewardView.this));
        
        KiipNativeRewardView.i(KiipNativeRewardView.this).setVisibility(8);
        KiipNativeRewardView.j(KiipNativeRewardView.this).setVisibility(0);
        

        String str1 = "";
        if (KiipNativeRewardView.k(KiipNativeRewardView.this).size() > 0) {
          LinkedList localLinkedList = new LinkedList();
          for (String str2 : KiipNativeRewardView.k(KiipNativeRewardView.this).keySet()) {
            try {
              localLinkedList.add(URLEncoder.encode(str2, "UTF-8") + "=" + URLEncoder.encode((String)KiipNativeRewardView.k(KiipNativeRewardView.this).get(str2), "UTF-8"));
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
          }
          
          str1 = "&" + android.text.TextUtils.join("&", localLinkedList);
        }
        
        if (Build.VERSION.SDK_INT < 19) {
          KiipNativeRewardView.j(KiipNativeRewardView.this).loadUrl("javascript:window.location.hash=\"#show" + str1 + "\";");
        } else {
          try {
            KiipNativeRewardView.j(KiipNativeRewardView.this).evaluateJavascript("javascript:window.location.hash=\"#show" + str1 + "\";", null);
          }
          catch (IllegalStateException localIllegalStateException) {}
        }
        

        KiipNativeRewardView.l(KiipNativeRewardView.this).a();
      }
      
      public void b()
      {
        KiipNativeRewardView.d(KiipNativeRewardView.this).removeCallbacks(KiipNativeRewardView.h(KiipNativeRewardView.this));
        KiipNativeRewardView.l(KiipNativeRewardView.this).b();
      }
      
      public void a(boolean paramAnonymousBoolean)
      {
        cancelReward();
        KiipNativeRewardView.l(KiipNativeRewardView.this).a(paramAnonymousBoolean);
      }
    });
    c.setOnWebViewErrorListener(new me.kiip.internal.h.c.d()
    {
      public void a(g paramAnonymousG) {}
    });
  }
  

  public void setRewardViewType(RewardViewType type)
  {
    n = type;
    forceLayout();
  }
  
  public void setOnContentListener(Kiip.OnContentListener listener) {
    l = listener;
  }
  
  public void setOnShowListener(OnShowListener listener) {
    k = listener;
  }
  
  public void showReward(final Kiip kiip, final Poptart poptart) {
    if (poptart != null) {
      new Handler().post(new Runnable()
      {
        public void run() {
          KiipNativeRewardView.c(KiipNativeRewardView.this, false);
          KiipNativeRewardView.i(KiipNativeRewardView.this).setTitle(poptart.getTitle());
          KiipNativeRewardView.i(KiipNativeRewardView.this).setMessage(poptart.getMessage());
          if (KiipNativeRewardView.m(KiipNativeRewardView.this) != null) {
            KiipNativeRewardView.j(KiipNativeRewardView.this).setOnContentListener(KiipNativeRewardView.m(KiipNativeRewardView.this));
          }
          if (KiipNativeRewardView.n(KiipNativeRewardView.this) != null) {
            KiipNativeRewardView.n(KiipNativeRewardView.this).onShow(kiip);
          }
          KiipNativeRewardView.j(KiipNativeRewardView.this).loadUrl(poptart.getRewardURL());
          KiipNativeRewardView.d(KiipNativeRewardView.this).postDelayed(KiipNativeRewardView.h(KiipNativeRewardView.this), 500L);
        }
      });
    }
  }
  
  public boolean isRewardRendered() {
    return c.getVisibility() == 0;
  }
  
  public static abstract interface OnShowListener
  {
    public abstract void onShow(Kiip paramKiip);
  }
  
  public static enum RewardViewType
  {
    private RewardViewType() {}
  }
}
