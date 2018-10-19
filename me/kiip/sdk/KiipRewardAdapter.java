package me.kiip.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import me.kiip.internal.e.a;
import me.kiip.internal.e.a.a;
import me.kiip.internal.e.b;
import me.kiip.internal.e.g;
import me.kiip.internal.h.c;
import me.kiip.internal.h.c.a;
import me.kiip.internal.h.c.b;
import me.kiip.internal.h.e;
import org.json.JSONException;
import org.json.JSONObject;

public class KiipRewardAdapter extends BaseAdapter
{
  private final Adapter c;
  private final Activity d;
  private boolean e = false;
  
  private TreeMap f = new TreeMap();
  private int g = 2;
  private JSONObject h = null;
  
  HashMap<String, String> a;
  
  private Handler i;
  
  private Runnable j = new Runnable()
  {
    public void run() {
      KiipRewardAdapter.a(KiipRewardAdapter.this);
    }
  };
  private Runnable k = new Runnable()
  {
    public void run() {
      KiipRewardAdapter.a(KiipRewardAdapter.this, false);
    }
  };
  

  private LinearLayout l;
  

  private e m;
  

  private c n;
  

  private VideoView o;
  

  private ImageView p;
  

  private ImageButton q;
  

  private boolean r;
  
  private Runnable s;
  
  boolean b;
  
  private View.OnClickListener t = new View.OnClickListener()
  {
    public void onClick(View v) {
      if (!KiipRewardAdapter.b(KiipRewardAdapter.this))
      {

        KiipRewardAdapter.a(KiipRewardAdapter.this, true);
        
        KiipRewardAdapter.d(KiipRewardAdapter.this).postDelayed(KiipRewardAdapter.c(KiipRewardAdapter.this), 3000L);
      }
    }
  };
  
  public KiipRewardAdapter(Activity activity, Adapter originalAdapter, int rewardPosition)
  {
    c = originalAdapter;
    d = activity;
    if (rewardPosition > 0) {
      g = rewardPosition;
    }
    
    c.registerDataSetObserver(new DataSetObserver()
    {
      public void onChanged() {
        notifyDataSetChanged();
      }
      
      public void onInvalidated()
      {
        notifyDataSetInvalidated();
      }
    });
    a();
    a = new HashMap();
  }
  
  private void a() {
    Activity localActivity = d;
    


    o = new VideoView(localActivity)
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
          KiipRewardAdapter.e(KiipRewardAdapter.this).setVisibility(0);
          
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
          localAlphaAnimation.setDuration(2000L);
          localAlphaAnimation.setRepeatCount(0);
          localAlphaAnimation.setRepeatMode(2);
          localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public void onAnimationStart(Animation animation) {}
            


            public void onAnimationEnd(Animation animation)
            {
              KiipRewardAdapter.e(KiipRewardAdapter.this).setVisibility(8);
            }
            



            public void onAnimationRepeat(Animation animation) {}
          });
          KiipRewardAdapter.e(KiipRewardAdapter.this).startAnimation(localAlphaAnimation);
          pause();
        }
        else if ((!isPlaying()) && (mv.getAction() == 0)) {
          KiipRewardAdapter.e(KiipRewardAdapter.this).setVisibility(8);
          seekTo(getCurrentPosition());
          start();
        }
        return true;
      }
      
    };
    i = new Handler();
    
    Resources localResources = localActivity.getResources();
    int i1 = localResources.getIdentifier("kp_play_video", "drawable", localActivity.getPackageName());
    int i2 = localResources.getIdentifier("kp_cancel_video", "drawable", localActivity.getPackageName());
    if ((i1 <= 0) || (i2 <= 0)) {
      Log.w("KiipSDK", "Unable to find kp_play_video.png or kp_cancel_video in drawable-*");
    }
    
    p = new ImageView(localActivity);
    q = new ImageButton(localActivity);
    p.setImageResource(i1);
    q.setImageResource(i2);
    
    l = new LinearLayout(localActivity);
    
    RelativeLayout localRelativeLayout = new RelativeLayout(localActivity);
    m = new e(localActivity);
    n = new c(localActivity, o, q);
    o.setId(Integer.valueOf(5).intValue());
    localRelativeLayout.addView(m, new RelativeLayout.LayoutParams(-2, -2) {});
    localRelativeLayout.addView(n, new RelativeLayout.LayoutParams(-1, -1));
    
    localRelativeLayout.addView(o, new RelativeLayout.LayoutParams(-1, -1) {});
    localRelativeLayout.addView(p, new RelativeLayout.LayoutParams(-2, -2) {});
    localRelativeLayout.addView(q, new RelativeLayout.LayoutParams(-2, -2) {});
    float f1 = getResourcesgetDisplayMetricsdensity;
    int i3 = (int)(320.0F * f1 + 0.5F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i3);
    localRelativeLayout.setLayoutParams(localLayoutParams);
    
    l.addView(localRelativeLayout);
    
    setupViews();
  }
  
  private c.a u = new c.a()
  {
    public void a() {
      if (KiipRewardAdapter.f(KiipRewardAdapter.this) != null) {
        KiipRewardAdapter.f(KiipRewardAdapter.this).run();
      }
    }
    
    public void b()
    {
      b = true;
      cancelReward();
    }
    

    public void a(boolean paramAnonymousBoolean) {}
  };
  

  public void setupViews()
  {
    Activity localActivity = d;
    int i1 = localActivity.getResources().getIdentifier("modal", "id", localActivity.getPackageName());
    if (i1 != 0) {
      l.setId(i1);
    }
    
    o.setVisibility(4);
    p.setVisibility(4);
    q.setVisibility(4);
    
    m.setVisibility(4);
    m.setOnClickListener(t);
    
    n.setVisibility(4);
    
    if (Build.VERSION.SDK_INT >= 19) {
      c.setWebContentsDebuggingEnabled(true);
    }
    
    n.setOnShowURLListener(new c.b()
    {

      public void a(boolean paramAnonymousBoolean) {}


    });
    n.setOnJSListener(new c.a()
    {
      public void a()
      {
        KiipRewardAdapter.d(KiipRewardAdapter.this).removeCallbacks(KiipRewardAdapter.g(KiipRewardAdapter.this));
        
        KiipRewardAdapter.h(KiipRewardAdapter.this).setVisibility(8);
        KiipRewardAdapter.i(KiipRewardAdapter.this).setVisibility(0);
        





        String str1 = "";
        if (a.size() > 0) {
          LinkedList localLinkedList = new LinkedList();
          for (String str2 : a.keySet()) {
            try {
              localLinkedList.add(URLEncoder.encode(str2, "UTF-8") + "=" + URLEncoder.encode((String)a.get(str2), "UTF-8"));
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
          }
          
          str1 = "&" + android.text.TextUtils.join("&", localLinkedList);
        }
        
        if (Build.VERSION.SDK_INT < 19) {
          KiipRewardAdapter.i(KiipRewardAdapter.this).loadUrl("javascript:window.location.hash=\"#show" + str1 + "\";");
        } else {
          try {
            KiipRewardAdapter.i(KiipRewardAdapter.this).evaluateJavascript("javascript:window.location.hash=\"#show" + str1 + "\";", null);
          }
          catch (IllegalStateException localIllegalStateException) {}
        }
        

        KiipRewardAdapter.j(KiipRewardAdapter.this).a();
      }
      
      public void b()
      {
        KiipRewardAdapter.d(KiipRewardAdapter.this).removeCallbacks(KiipRewardAdapter.g(KiipRewardAdapter.this));
        KiipRewardAdapter.j(KiipRewardAdapter.this).b();
      }
      
      public void a(boolean paramAnonymousBoolean)
      {
        cancelReward();
        KiipRewardAdapter.j(KiipRewardAdapter.this).a(paramAnonymousBoolean);
      }
    });
    n.setOnWebViewErrorListener(new me.kiip.internal.h.c.d()
    {
      public void a(g paramAnonymousG) {}
    });
  }
  

  private void b()
  {
    m.setVisibility(0);
  }
  
  public void showReward() {
    if (h != null) {
      e = true;
      f.put(Integer.valueOf(g), h);
      m.setTitle(h.optString("title", null));
      m.setMessage(h.optString("message", null));
      r = false;
      n.loadUrl(h.optString("body_url", ""));
      i.postDelayed(j, 500L);
      notifyDataSetChanged();
      h = null;
    }
  }
  
  public void cancelReward() {
    i.removeCallbacks(j);
    i.removeCallbacks(k);
    try
    {
      n.stopLoading();
    }
    catch (NullPointerException localNullPointerException) {}
    

    e = false;
    notifyDataSetChanged();
  }
  






  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      r = true;
    } else {
      r = false;
    }
    m.a(paramBoolean);
  }
  
  public boolean areAllItemsEnabled()
  {
    return ((c instanceof ListAdapter)) && (((ListAdapter)c).areAllItemsEnabled());
  }
  
  public boolean isEnabled(int position)
  {
    return ((c instanceof ListAdapter)) && (((ListAdapter)c).isEnabled(position));
  }
  
  public int getCount()
  {
    if (e) {
      return c.getCount() + f.size();
    }
    return c.getCount();
  }
  
  public Object getItem(int position)
  {
    if (e) {
      return f.get(Integer.valueOf(position));
    }
    return c.getItem(position);
  }
  
  public long getItemId(int position)
  {
    if (e) {
      return position + f.size();
    }
    return position;
  }
  

  public int getItemViewType(int position)
  {
    if ((e) && (position == g)) {
      return 1;
    }
    return c.getItemViewType(position);
  }
  
  public int getViewTypeCount()
  {
    return c.getViewTypeCount() + 1;
  }
  
  public boolean isEmpty()
  {
    return c.isEmpty();
  }
  
  public View getView(int position, View view, ViewGroup viewGroup)
  {
    Object localObject;
    if ((position == g) && (e)) {
      int i1 = getItemViewType(position);
      System.out.println("getView " + position + " " + view + " type = " + i1 + " item = " + getItem(position));
      localObject = l;
    } else {
      if ((position > g) && (e)) position--;
      localObject = c.getView(position, view, viewGroup);
    }
    
    return localObject;
  }
  


  public void saveMoment(String id, final NativeCallback callback)
  {
    e = false;
    h = null;
    f = new TreeMap();
    
    a.b().a(id, null, null, new a.a()
    {
      public void a(JSONObject paramAnonymousJSONObject) {
        boolean bool = false;
        if (paramAnonymousJSONObject != null) {
          try {
            JSONObject localJSONObject1 = paramAnonymousJSONObject.optJSONObject("view");
            if (localJSONObject1 != null) {
              JSONObject localJSONObject2 = localJSONObject1.getJSONObject("modal");
              if (localJSONObject2 != null) {
                KiipRewardAdapter.a(KiipRewardAdapter.this, localJSONObject2);
                bool = true;
              } else {
                notifyDataSetChanged();
              }
            }
            if (b.a) Log.d("KiipRewardAdapter", "saveMoment Finished");
          } catch (JSONException localJSONException) {
            if (b.a) Log.e("KiipRewardAdapter", "Invalid Poptart JSON");
          }
        }
        if (callback != null) {
          callback.onSuccess(bool);
        }
      }
      
      public void a(Exception paramAnonymousException)
      {
        if (callback != null) {
          callback.onFailed(paramAnonymousException);
        }
      }
    });
  }
  
  public static abstract interface NativeCallback
  {
    public abstract void onFailed(Exception paramException);
    
    public abstract void onSuccess(boolean paramBoolean);
  }
}
