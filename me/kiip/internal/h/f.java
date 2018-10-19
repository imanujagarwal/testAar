package me.kiip.internal.h;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.moat.analytics.mobile.kiip.MoatFactory;
import com.moat.analytics.mobile.kiip.WebAdTracker;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import me.kiip.internal.e.b;
import me.kiip.sdk.Kiip.OnContentListener;
import me.kiip.sdk.Modal;
import me.kiip.sdk.Modal.OnDismissListener;
import me.kiip.sdk.Modal.OnShowListener;
import me.kiip.sdk.Modal.VideoListener;
import me.kiip.sdk.Modal.WebViewListener;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends Modal implements DialogInterface.OnCancelListener, android.content.DialogInterface.OnClickListener, DialogInterface.OnDismissListener
{
  private static final boolean k = b.a;
  String a;
  String b;
  String c;
  int d;
  HashMap<String, String> e;
  
  static f a(JSONObject paramJSONObject) throws JSONException
  {
    return new f(paramJSONObject.optString("title", null), paramJSONObject.optString("message", null), paramJSONObject.getString("body_url"), paramJSONObject.optInt("timeout", 10) * 1000);
  }
  

  private Context l;
  
  private a m;
  
  private Runnable n;
  
  private Runnable o;
  
  private Runnable p;
  
  private Modal.OnShowListener q;
  
  private Modal.OnDismissListener r;
  
  private Kiip.OnContentListener s;
  
  private Modal.VideoListener t;
  
  private Modal.WebViewListener u;
  
  private boolean v;
  
  boolean f;
  boolean g;
  boolean h;
  boolean i;
  me.kiip.internal.e.g j;
  private JSONObject w;
  private f(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    a = paramString1;
    b = paramString2;
    c = paramString3;
    d = paramInt;
  }
  


  public boolean isShowing()
  {
    return v;
  }
  
  public void setOnShowListener(Modal.OnShowListener listener)
  {
    q = listener;
  }
  
  public void setOnDismissListener(Modal.OnDismissListener listener)
  {
    r = listener;
  }
  
  void a(Kiip.OnContentListener paramOnContentListener) {
    s = paramOnContentListener;
  }
  
  public void setVideoListener(Modal.VideoListener listener) {
    t = listener;
  }
  
  public void setWebViewListener(Modal.WebViewListener listener)
  {
    u = listener;
  }
  
  public void b(JSONObject paramJSONObject) {
    w = paramJSONObject;
  }
  

  void a(Context paramContext, boolean paramBoolean, Runnable paramRunnable1, Runnable paramRunnable2, Runnable paramRunnable3)
  {
    if (v) {
      return;
    }
    v = true;
    
    l = paramContext;
    m = a(paramContext);
    n = paramRunnable1;
    o = paramRunnable2;
    p = paramRunnable3;
    
    if (q != null) {
      q.onShow(this);
    }
    
    m.a = e;
    if (b.a) Log.d("ModalImpl", "loadUrl");
    m.c(c);
    
    m.show();
  }
  
  private c.b x = new c.b()
  {
    public void a(boolean paramAnonymousBoolean) {
      h = true;
    }
  };
  
  private c.a y = new c.a()
  {
    public void a() {
      if (f.a(f.this) != null) {
        f.a(f.this).run();
      }
    }
    
    public void b()
    {
      g = true;
      f.b(f.this).run();
      f.c(f.this).cancel();
      f.a(f.this, "Unable to load reward");
    }
    
    public void a(boolean paramAnonymousBoolean)
    {
      if (!paramAnonymousBoolean) {
        i = false;
      } else {
        i = true;
      }
    }
  };
  
  private c.d z = new c.d()
  {
    public void a(me.kiip.internal.e.g paramAnonymousG) {
      j = paramAnonymousG;
      
      f.b(f.this).run();
      f.a(f.this, paramAnonymousG.getMessage());
    }
  };
  
  private void a(String paramString)
  {
    Log.e("ModalImpl", "Kiip Error: " + paramString);
    a(false);
  }
  
  void a(boolean paramBoolean) {
    if (!v) {
      return;
    }
    


    if ((m != null) || (m.isShowing())) {
      m.setOnDismissListener(null);
      m.setOnCancelListener(null);
    }
    
    v = false;
    
    if (!paramBoolean) {
      if (r != null) {
        r.onDismiss(this);
      }
      
      p.run();
    }
  }
  
  private a a(Context paramContext) {
    a localA = new a(paramContext);
    
    localA.setCanceledOnTouchOutside(false);
    localA.setCancelable(false);
    localA.setOnCancelListener(this);
    localA.setOnDismissListener(this);
    
    localA.a(a);
    localA.b(b);
    localA.a(y);
    localA.a(z);
    localA.a(x);
    localA.a(s);
    localA.a(t);
    localA.a(u);
    

    localA.a(w);
    
    return localA;
  }
  


  public void onClick(DialogInterface dialog, int which)
  {
    a(false);
  }
  



  public void onCancel(DialogInterface dialog)
  {
    if (dialog.equals(m)) {
      f = true;
    }
    a(false);
  }
  
  public void onDismiss(DialogInterface dialog)
  {
    a(false);
  }
  




  private static class a
    extends me.kiip.internal.e.c
  {
    private Handler b;
    



    private Runnable c = new Runnable()
    {
      public void run() {
        f.a.a(f.a.this);
      }
    };
    private Runnable d = new Runnable()
    {
      public void run() {
        f.a.a(f.a.this, false);
      }
    };
    
    private RelativeLayout e;
    
    private e f;
    
    private c g;
    
    private ImageView h;
    
    private ImageButton i;
    
    private WebAdTracker j;
    private a k;
    private JSONObject l;
    private VideoView m = new VideoView(getContext())
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
          f.a.b(f.a.this).setVisibility(0);
          
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
          localAlphaAnimation.setDuration(2000L);
          localAlphaAnimation.setRepeatCount(0);
          localAlphaAnimation.setRepeatMode(2);
          localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public void onAnimationStart(Animation animation) {}
            


            public void onAnimationEnd(Animation animation)
            {
              f.a.b(f.a.this).setVisibility(8);
            }
            



            public void onAnimationRepeat(Animation animation) {}
          });
          f.a.b(f.a.this).startAnimation(localAlphaAnimation);
          pause();
        }
        else if ((!isPlaying()) && (mv.getAction() == 0)) {
          f.a.b(f.a.this).setVisibility(8);
          seekTo(getCurrentPosition());
          start();
        }
        return true;
      }
    };
    
    private boolean n;
    private View.OnClickListener o = new View.OnClickListener()
    {
      public void onClick(View v) {
        if (f.a.c(f.a.this)) {
          cancel();
        } else {
          f.a.a(f.a.this, true);
          
          f.a.e(f.a.this).postDelayed(f.a.d(f.a.this), 3000L);
        }
      }
    };
    
    private c.a p;
    private c.d q;
    private c.b r;
    private String s;
    public HashMap<String, String> a;
    
    public a(Context paramContext)
    {
      super();
      b();
    }
    
    private void b() {
      Context localContext = getContext();
      
      b = new Handler();
      
      Resources localResources = localContext.getResources();
      int i1 = localResources.getIdentifier("kp_play_video", "drawable", localContext.getPackageName());
      int i2 = localResources.getIdentifier("kp_cancel_video", "drawable", localContext.getPackageName());
      if ((i1 <= 0) || (i2 <= 0)) {
        Log.w("KiipSDK", "Unable to find kp_play_video.png or kp_cancel_video in drawable-*");
      }
      
      h = new ImageView(localContext);
      i = new ImageButton(localContext);
      h.setImageResource(i1);
      i.setImageResource(i2);
      
      e = new RelativeLayout(localContext);
      f = new e(localContext);
      
      k = new a(localContext);
      
      g = new c(localContext, m, k, i);
      m.setId(Integer.valueOf(5).intValue());
      
      e.addView(f, new RelativeLayout.LayoutParams(-2, -2) {});
      FrameLayout localFrameLayout = new FrameLayout(localContext);
      localFrameLayout.addView(k, new ViewGroup.LayoutParams(-1, -1));
      e.addView(localFrameLayout, new RelativeLayout.LayoutParams(-1, -1));
      
      e.addView(g, new RelativeLayout.LayoutParams(-1, -1));
      

      e.addView(m, new RelativeLayout.LayoutParams(-1, -1) {});
      e.addView(h, new RelativeLayout.LayoutParams(-2, -2) {});
      e.addView(i, new RelativeLayout.LayoutParams(-2, -2) {});
      MoatFactory localMoatFactory = MoatFactory.create();
      j = localMoatFactory.createWebAdTracker(g);
    }
    
    protected void onCreate(Bundle savedInstanceState)
    {
      super.onCreate(savedInstanceState);
      a();
      setContentView(e);
    }
    
    @TargetApi(19)
    public void a() {
      final Context localContext = getContext();
      int i1 = localContext.getResources().getIdentifier("modal", "id", localContext.getPackageName());
      if (i1 != 0) {
        e.setId(i1);
      }
      
      m.setVisibility(4);
      h.setVisibility(4);
      i.setVisibility(4);
      
      f.setVisibility(4);
      f.setOnClickListener(o);
      
      g.setVisibility(4);
      k.b();
      
      g.setOnShowURLListener(new c.b()
      {
        public void a(boolean paramAnonymousBoolean) {
          f.a.f(f.a.this).a(paramAnonymousBoolean);
        }
        
      });
      g.setOnViewObjectListener(new c.c()
      {
        public void a() {
          try {
            SharedPreferences localSharedPreferences = localContext.getSharedPreferences("me.kiip.sdk", 0);
            SharedPreferences.Editor localEditor = localSharedPreferences.edit();
            SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            f.a.g(f.a.this).put("last_cache_date", localSimpleDateFormat.format(new Date()));
            localEditor.putString("view", f.a.g(f.a.this).toString());
            localEditor.apply();
            Log.d("ModalImpl", "saved reward object");
          } catch (Exception localException) {
            if (b.a) Log.d("ModalImpl", localException.toString());
          }
        }
        
        public void b()
        {
          SharedPreferences localSharedPreferences = localContext.getSharedPreferences("me.kiip.sdk", 0);
          SharedPreferences.Editor localEditor = localSharedPreferences.edit();
          localEditor.remove("view");
          localEditor.apply();
          Log.d("ModalImpl", "removed reward object");
        }
        
      });
      g.setOnJSListener(new c.a()
      {
        public void a() {
          f.a.e(f.a.this).removeCallbacks(f.a.h(f.a.this));
          
          f.a.i(f.a.this).setVisibility(8);
          f.a.j(f.a.this).setVisibility(0);
          
          f.a.b(f.a.this, true);
          getWindow().setBackgroundDrawableResource(17170445);
          setCancelable(true);
          

          String str1 = "";
          if (a.size() > 0) {
            LinkedList localLinkedList = new LinkedList();
            for (String str2 : a.keySet()) {
              try {
                localLinkedList.add(URLEncoder.encode(str2, "UTF-8") + "=" + URLEncoder.encode((String)a.get(str2), "UTF-8"));
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
            }
            
            str1 = "&" + TextUtils.join("&", localLinkedList);
          }
          
          if (Build.VERSION.SDK_INT < 19) {
            f.a.j(f.a.this).loadUrl("javascript:window.location.hash=\"#show" + str1 + "\";");
          } else {
            try {
              f.a.j(f.a.this).evaluateJavascript("javascript:window.location.hash=\"#show" + str1 + "\";", null);
            }
            catch (IllegalStateException localIllegalStateException) {}
          }
          

          f.a.k(f.a.this).startTracking();
          f.a.l(f.a.this).a();
        }
        
        public void b()
        {
          f.a.e(f.a.this).removeCallbacks(f.a.h(f.a.this));
          f.a.l(f.a.this).b();
        }
        
        public void a(boolean paramAnonymousBoolean)
        {
          dismiss();
          f.a.l(f.a.this).a(paramAnonymousBoolean);
        }
      });
      g.setOnWebViewErrorListener(new c.d()
      {
        public void a(me.kiip.internal.e.g paramAnonymousG) {
          f.a.m(f.a.this).a(paramAnonymousG);
        }
      });
    }
    
    public void a(String paramString) {
      f.setTitle(paramString);
    }
    
    public void b(String paramString) {
      f.setMessage(paramString);
    }
    
    public void c(String paramString) {
      s = paramString;
    }
    
    public void a(c.b paramB) {
      r = paramB;
    }
    
    public void a(c.a paramA) {
      p = paramA;
    }
    
    public void a(c.d paramD) {
      q = paramD;
    }
    
    public void a(Kiip.OnContentListener paramOnContentListener) {
      g.setOnContentListener(paramOnContentListener);
    }
    
    public void a(Modal.VideoListener paramVideoListener) {
      g.setVideoListener(paramVideoListener);
    }
    
    public void a(Modal.WebViewListener paramWebViewListener) {
      g.setWebViewListener(paramWebViewListener);
    }
    
    public void a(JSONObject paramJSONObject) {
      l = paramJSONObject;
    }
    
    public void show()
    {
      n = false;
      g.loadUrl(s);
      
      b.postDelayed(c, 500L);
      super.show();
    }
    
    private void c() {
      me.kiip.internal.g.g.a(getContext()).c();
    }
    

    public void cancel()
    {
      super.cancel();
    }
    
    public void dismiss()
    {
      b.removeCallbacks(c);
      b.removeCallbacks(d);
      try {
        g.stopLoading();
      }
      catch (NullPointerException localNullPointerException) {}
      


      ViewGroup localViewGroup = (ViewGroup)g.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(g);
      }
      

      j.stopTracking();
      c();
      g.destroy();
      
      super.dismiss();
    }
    
    private void d() {
      f.setVisibility(0);
    }
    
    private void a(boolean paramBoolean) {
      if (paramBoolean) {
        n = true;
      } else {
        n = false;
      }
      f.a(paramBoolean);
    }
    
    private void b(boolean paramBoolean) {
      Window localWindow = getWindow();
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
      localLayoutParams.copyFrom(localWindow.getAttributes());
      if (paramBoolean) {
        width = -1;
        height = -1;
      } else {
        width = -2;
        height = -2;
      }
      localWindow.setAttributes(localLayoutParams);
    }
    
    public void onBackPressed()
    {
      if (m.isPlaying())
      {
        int i1 = m.getCurrentPosition() / 1000;
        int i2 = m.getDuration() / 1000;
        
        String str = "javascript:window.location.hash=\"#current_time=" + i1 + "," + i2 + "\";";
        if (Build.VERSION.SDK_INT < 19) {
          g.loadUrl(str);
        } else {
          g.evaluateJavascript(str, null);
        }
        
        m.setVisibility(8);
        RelativeLayout localRelativeLayout = (RelativeLayout)g.getParent();
        localRelativeLayout.setBackgroundColor(0);
        g.setVisibility(0);
        k.setVisibility(8);
        i.setVisibility(8);
        

        if (g.getVideoListener() != null) {
          g.getVideoListener().onVideoStopped();
        }
      }
      else {
        super.onBackPressed();
      }
    }
  }
}
