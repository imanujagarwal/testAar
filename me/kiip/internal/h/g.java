package me.kiip.internal.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import me.kiip.internal.e.b;
import me.kiip.sdk.Notification;
import me.kiip.sdk.Notification.OnClickListener;
import me.kiip.sdk.Notification.OnDismissListener;
import me.kiip.sdk.Notification.OnShowListener;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends Notification implements View.OnClickListener
{
  private static final boolean h = b.a;
  




  static g a(JSONObject paramJSONObject)
    throws JSONException
  {
    String str = paramJSONObject.optString("position");
    int i1 = 48;
    
    if (str.toLowerCase().equals("top")) {
      i1 = 48;
    } else if (str.toLowerCase().equals("bottom")) {
      i1 = 80;
    }
    


    return new g(paramJSONObject.getString("title"), paramJSONObject.getString("message"), paramJSONObject
      .optString("icon_url", null), i1, paramJSONObject.optInt("timeout", 10) * 1000);
  }
  
  private static final WindowManager.LayoutParams i = new WindowManager.LayoutParams(-2, -2, 0, 0, 2, 40, -3);
  

  String a;
  

  String b;
  
  String c;
  
  int d;
  
  int e;
  
  Bitmap f;
  
  private boolean j;
  
  private WindowManager k;
  
  private FrameLayout l;
  
  private WindowManager.LayoutParams m;
  
  private View n;
  
  private Animation o;
  
  private Animation p;
  
  private Handler q;
  
  private Runnable r = new Runnable()
  {
    public void run() {
      a(false);
    }
  };
  
  private Runnable s;
  
  private Notification.OnShowListener t;
  private Notification.OnClickListener u;
  private Notification.OnDismissListener v;
  boolean g = false;
  
  private g(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {
    a = paramString1;
    b = paramString2;
    c = paramString3;
    d = paramInt1;
    e = paramInt2;
    
    if (b.a) android.util.Log.d("NotificationImpl", "[DEBUG] Initializing NotificationImpl title=" + paramString1 + " message=" + paramString2 + " iconUrl=" + paramString3 + " gravity=" + paramInt1 + " timeout=" + paramInt2);
  }
  
  void a(Context paramContext) {
    l = new a(paramContext);
    l.setOnClickListener(this);
  }
  


  public boolean isShowing()
  {
    return j;
  }
  
  public String getTitle()
  {
    return a;
  }
  
  public void setTitle(String title)
  {
    a = title;
  }
  
  public String getMessage()
  {
    return b;
  }
  
  public void setMessage(String message)
  {
    b = message;
  }
  
  public Bitmap getIcon()
  {
    return f;
  }
  
  public void setIcon(Bitmap icon)
  {
    f = icon;
  }
  
  public int getGravity()
  {
    return d;
  }
  
  public void setGravity(int gravity)
  {
    d = gravity;
  }
  
  public void setOnShowListener(Notification.OnShowListener listener)
  {
    t = listener;
  }
  
  public void setOnClickListener(Notification.OnClickListener listener)
  {
    u = listener;
  }
  
  public void setOnDismissListener(Notification.OnDismissListener listener)
  {
    v = listener;
  }
  





  public void setContentView(View view)
  {
    n = view;
  }
  
  public View a() {
    return n;
  }
  
  ViewGroup b() {
    return l;
  }
  

  void a(Context paramContext, boolean paramBoolean, Runnable paramRunnable)
  {
    if (j) {
      return;
    }
    j = true;
    
    q = new Handler();
    k = ((WindowManager)paramContext.getSystemService("window"));
    s = paramRunnable;
    

    m = new WindowManager.LayoutParams();
    m.copyFrom(i);
    m.setTitle("[Kiip] Notification");
    m.gravity = (d & 0x30 | d & 0x50);
    ViewGroup.LayoutParams localLayoutParams = n.getLayoutParams();
    if (localLayoutParams != null) {
      m.width = width;
    }
    



    int i1 = (d & 0x30) == 48 ? 1 : 0;
    float f1 = i1 != 0 ? -1.0F : 1.0F;
    o = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, f1, 1, 0.0F);
    

    p = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, f1);
    

    o.setDuration(300L);
    p.setDuration(300L);
    
    if (t != null) {
      t.onShow(this);
    }
    

    l.addView(n);
    k.addView(l, m);
    

    if (paramBoolean) {
      n.startAnimation(o);
    }
    

    if (e > 0) {
      q.postDelayed(r, e);
    }
  }
  
  void a(boolean paramBoolean) {
    if (!j) {
      return;
    }
    
    q.removeCallbacks(r);
    

    if (paramBoolean) {
      c();
    } else {
      n.startAnimation(p);
      

      n.postDelayed(new Runnable()
      {
        public void run() {
          g.a(g.this);
          
          if (g.b(g.this) != null) {
            g.b(g.this).onDismiss(g.this);
          }
          
          g.c(g.this).run();
        }
      }, p.getDuration());
    }
  }
  
  private void c() {
    l.removeAllViews();
    n = null;
    if (l.getParent() != null) {
      k.removeView(l);
    }
    j = false;
  }
  


  public void onClick(View v)
  {
    g = true;
    
    if (u != null) {
      u.onClick(this);
    }
    
    a(false);
  }
  
  private static class a extends FrameLayout
  {
    public a(Context paramContext) {
      super();
    }
  }
}
