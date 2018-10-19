package me.kiip.internal.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.HashMap;
import me.kiip.internal.a.p.a;
import me.kiip.internal.a.p.b;
import me.kiip.internal.a.u;
import me.kiip.internal.b.k;
import me.kiip.internal.e.a;
import me.kiip.internal.e.b;
import me.kiip.sdk.Kiip.KiipAdapter;
import me.kiip.sdk.Kiip.OnContentListener;
import me.kiip.sdk.Notification;
import me.kiip.sdk.Poptart;
import org.json.JSONException;
import org.json.JSONObject;

public class i
{
  private static final boolean a = b.a;
  

  private final a b;
  

  private final HashMap<String, String> c;
  

  private Kiip.KiipAdapter d;
  
  private Kiip.OnContentListener e;
  

  public i(a paramA)
  {
    if (b.a) { Log.d("PoptartManager", "[DEBUG] Instantiating PoptartManager");
    }
    b = paramA;
    
    c = new HashMap();
  }
  

  public HashMap<String, String> a()
  {
    return c;
  }
  
  public String b() {
    return (String)c.get("email");
  }
  
  public void a(String paramString) {
    c.put("email", paramString);
  }
  



  public void a(Kiip.KiipAdapter paramKiipAdapter)
  {
    d = paramKiipAdapter;
  }
  
  public Kiip.OnContentListener c() {
    return e;
  }
  
  public void a(Kiip.OnContentListener paramOnContentListener) {
    e = paramOnContentListener;
  }
  


  public void a(JSONObject paramJSONObject, final a paramA)
  {
    try
    {
      final h localH = h.a(this, paramJSONObject);
      localH.a(e);
      f localF = localH.c();
      localF.a(e);
      final long l = System.currentTimeMillis();
      

      if (localH.b() == null) {
        paramA.a(this, localH, null);
      } else {
        b.c().a(new k(bc, new p.b()
        {
          public void a(Bitmap paramAnonymousBitmap) {
            a("notification_preload", Long.valueOf(l), Long.valueOf(System.currentTimeMillis()), paramA.a(), null, null, null);
            
            paramAbf = paramAnonymousBitmap;
            
            c.a(i.this, paramA, null); } }, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, new p.a()
        {

          public void a(u paramAnonymousU)
          {
            paramA.a(i.this, localH, paramAnonymousU);
          }
        }));
      }
    } catch (JSONException localJSONException) {
      if (b.a) Log.e("PoptartManager", "Invalid Poptart JSON");
      paramA.a(this, null, localJSONException);
    }
  }
  
  public View a(Context paramContext, h paramH)
  {
    b localB = d != null ? d.getNotificationView(paramContext, paramH.b().b(), paramH) : new b(paramContext, paramH);
    

    return localB;
  }
  
  public void a(String paramString1, Long paramLong1, Long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5) {
    Bundle localBundle = new Bundle();
    
    if (paramString2 != null) {
      localBundle.putString("view_id", paramString2);
    }
    
    if ((paramString3 != null) && (paramString4 != null) && (paramString5 != null)) {
      localBundle.putString("error_code", paramString3);
      localBundle.putString("error_description", paramString4);
      localBundle.putString("error_failing_url", paramString5);
    }
    
    b.a(paramString1, paramLong1, paramLong2, localBundle);
  }
  
  private static class b extends RelativeLayout
  {
    public b(Context paramContext, Poptart paramPoptart) {
      super();
      Notification localNotification = paramPoptart.getNotification();
      float f = getResourcesgetDisplayMetricsdensity;
      

      int i = getResources().getIdentifier("kp_notification_bg", "drawable", getContext().getPackageName());
      if (i == 0) {
        Log.w("KiipSDK", "Unable to find kp_notification_bg.png in drawable-*");
      }
      
      setBackgroundResource(i);
      setLayoutParams(new RelativeLayout.LayoutParams(-1, (int)(46.0F * f)));
      

      ImageView localImageView = new ImageView(paramContext);
      localImageView.setImageBitmap(localNotification.getIcon());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(55.0F * f), (int)(42.0F * f));
      leftMargin = ((int)(5.0F * f));
      topMargin = ((int)(0.0F * f));
      addView(localImageView, localLayoutParams);
      

      TextView localTextView1 = new TextView(paramContext);
      localTextView1.setEllipsize(TextUtils.TruncateAt.END);
      localTextView1.setSingleLine();
      localTextView1.setText(localNotification.getTitle());
      localTextView1.setTextColor(Color.parseColor("#7c8080"));
      localTextView1.setTextSize(12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      leftMargin = ((int)(65.0F * f));
      topMargin = ((int)(4.0F * f));
      rightMargin = ((int)(30.0F * f));
      addView(localTextView1, localLayoutParams);
      

      TextView localTextView2 = new TextView(paramContext);
      localTextView2.setEllipsize(TextUtils.TruncateAt.END);
      localTextView2.setSingleLine();
      localTextView2.setText(localNotification.getMessage());
      localTextView2.setTextColor(Color.parseColor("#9b9f9f"));
      localTextView2.setTextSize(12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      leftMargin = ((int)(65.0F * f));
      topMargin = ((int)(21.0F * f));
      rightMargin = ((int)(10.0F * f));
      addView(localTextView2, localLayoutParams);
    }
    
    public void setPressed(boolean pressed)
    {
      me.kiip.internal.g.h.a(this, !pressed ? 1.0F : 0.8F);
      super.setPressed(pressed);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(i paramI, Poptart paramPoptart, Exception paramException);
  }
}
