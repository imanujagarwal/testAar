package me.kiip.internal.h;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import me.kiip.sdk.KiipNativeRewardView;
import org.json.JSONException;
import org.json.JSONObject;

final class h extends me.kiip.sdk.Poptart
{
  private i a;
  private String b;
  private g c;
  private f d;
  private DialogInterface.OnShowListener e;
  private me.kiip.sdk.Kiip.OnContentListener f;
  private DialogInterface.OnDismissListener g;
  private boolean h;
  private long i;
  private long j;
  
  static h a(i paramI, JSONObject paramJSONObject) throws JSONException
  {
    g localG = null;
    f localF = null;
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("notification");
    JSONObject localJSONObject2 = paramJSONObject.getJSONObject("modal");
    try
    {
      if (localJSONObject1 != null) {
        localG = g.a(localJSONObject1);
      }
    }
    catch (JSONException localJSONException) {}
    

    if (localJSONObject2 != null) {
      localF = f.a(localJSONObject2);
      localF.b(paramJSONObject);
    }
    
    return new h(paramI, paramJSONObject.getString("id"), localG, localF);
  }
  














  private h(i paramI, String paramString, g paramG, f paramF)
  {
    a = paramI;
    b = paramString;
    c = paramG;
    d = paramF;
  }
  


  public boolean isShowing()
  {
    return h;
  }
  
  public String a() {
    return b;
  }
  
  public g b()
  {
    return c;
  }
  




  public void setNotification(me.kiip.sdk.Notification notification)
  {
    if (notification != null) {
      throw new RuntimeException("You may only set the notification to be null");
    }
    c = ((g)notification);
  }
  
  public f c()
  {
    return d;
  }
  




  public void setOnShowListener(DialogInterface.OnShowListener listener)
  {
    e = listener;
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener listener)
  {
    g = listener;
  }
  
  void a(me.kiip.sdk.Kiip.OnContentListener paramOnContentListener) {
    f = paramOnContentListener;
  }
  



  public String getTitle()
  {
    f localF = d;
    return a;
  }
  
  public String getMessage()
  {
    f localF = d;
    return b;
  }
  
  public String getRewardURL()
  {
    f localF = d;
    return c;
  }
  
  public void showNativeReward(KiipNativeRewardView rewardView)
  {
    rewardView.setOnContentListener(f);
    if (e != null) {
      e.onShow(this);
    }
    rewardView.showReward(me.kiip.sdk.Kiip.getInstance(), this);
  }
  
  public void show(Context context)
  {
    show(context, true);
  }
  
  public void show(final Context context, final boolean animate)
  {
    if (h) {
      return;
    }
    h = true;
    
    if (e != null) {
      e.onShow(this);
    }
    

    final g localG = c;
    if (localG != null)
    {
      if (i <= 0L) {
        i = System.currentTimeMillis();
        a("notification_show", Long.valueOf(i), null, a());
      }
      
      if (localG.a() == null) {
        localG.a(context);
        localG.setContentView(a.a(context, this));
      }
      localG.a(context, animate, new Runnable()
      {
        public void run() {
          if (localGg)
          {
            h.a(h.this, "notification_click", Long.valueOf(h.a(h.this)), Long.valueOf(System.currentTimeMillis()), a());
            
            h.a(h.this, context, animate);
          }
          else {
            h.a(h.this, "notification_dismiss", Long.valueOf(h.a(h.this)), Long.valueOf(System.currentTimeMillis()), a());
            
            h.b(h.this);
          }
          h.a(h.this, null);
        }
      });
    }
    else {
      a(context, animate);
    }
  }
  
  private void a(Context paramContext, boolean paramBoolean) {
    final f localF = d;
    if (localF != null)
    {
      if (j <= 0L) {
        j = System.currentTimeMillis();
        a("modal_show", Long.valueOf(j), null, a());
      }
      
      final long l = System.currentTimeMillis();
      e = a.a();
      localF.a(paramContext, paramBoolean, new Runnable()
      




        new Runnable
        {



          public void run() {
            h.a(h.this, "modal_load", Long.valueOf(l), Long.valueOf(System.currentTimeMillis()), a()); } }, new Runnable()
        











        new Runnable
        {


          public void run()
          {

            me.kiip.internal.e.g localG = localFj;
            if (localFg)
            {
              h.a(h.this, "modal_error", Long.valueOf(l), Long.valueOf(System.currentTimeMillis()), a());
            } else if (localG != null)
            {
              h.a(h.this, "modal_webview_error", Long.valueOf(l), Long.valueOf(System.currentTimeMillis()), a(), String.valueOf(localG.a()), localG.getMessage(), localG.b()); } } }, new Runnable()
        {


          public void run()
          {


            if (localFf)
            {
              h.a(h.this, "modal_cancel", Long.valueOf(h.c(h.this)), Long.valueOf(System.currentTimeMillis()), a());
            }
            else if (localFi)
            {
              h.a(h.this, "modal_dismiss_by_redemption", Long.valueOf(h.c(h.this)), Long.valueOf(System.currentTimeMillis()), a());
              if (localFh)
              {
                h.a(h.this, "url_opened", Long.valueOf(h.c(h.this)), Long.valueOf(System.currentTimeMillis()), a());
              }
            }
            else {
              h.a(h.this, "modal_dismiss_by_x_button", Long.valueOf(h.c(h.this)), Long.valueOf(System.currentTimeMillis()), a());
              if (localFh)
              {
                h.a(h.this, "url_opened", Long.valueOf(h.c(h.this)), Long.valueOf(System.currentTimeMillis()), a());
              }
            }
            
            h.b(h.this);
            h.a(h.this, null);
          }
        });
    }
    else {
      d();
    }
  }
  
  public void cancel()
  {
    a(true);
  }
  
  private void d() {
    h = false;
    
    if (g != null) {
      g.onDismiss(this);
    }
  }
  
  public void dismiss()
  {
    a(false);
  }
  




  public void a(boolean paramBoolean)
  {
    if (!h) {
      return;
    }
    if (paramBoolean) {
      h = false;
    }
    
    if (c != null) {
      c.a(paramBoolean);
    } else if (d != null) {
      d.a(paramBoolean);
    }
  }
  
  private void a(String paramString1, Long paramLong1, Long paramLong2, String paramString2) {
    a(paramString1, paramLong1, paramLong2, paramString2, null, null, null);
  }
  
  private void a(String paramString1, Long paramLong1, Long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5) {
    a.a(paramString1, paramLong1, paramLong2, paramString2, paramString3, paramString4, paramString5);
  }
}
