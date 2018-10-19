package me.kiip.internal.e;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import me.kiip.internal.a.n;
import me.kiip.internal.a.o;
import me.kiip.internal.a.p.a;
import me.kiip.internal.a.p.b;
import me.kiip.internal.a.u;
import me.kiip.internal.g.c;
import me.kiip.internal.g.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


























public class a
{
  private static final me.kiip.internal.f.a a = new me.kiip.internal.f.a();
  private final Handler b;
  
  static String a() { return UUID.randomUUID().toString(); }
  


  private final Runnable c = new Runnable()
  {
    public void run() {
      b(null);
    }
  };
  private final int d = 30000;
  
  private o e;
  
  private final ConnectivityManager f;
  
  private final LocationManager g;
  
  private final String h;
  private final String i;
  private final String j;
  private String k;
  private Boolean l = Boolean.valueOf(false);
  
  private Context m;
  private final JSONObject n = new JSONObject();
  private final JSONObject o = new JSONObject();
  private final JSONObject p = new JSONObject();
  private final JSONObject q = new JSONObject();
  private final JSONObject r = new JSONObject();
  private final JSONObject s = new JSONObject();
  
  private JSONObject t;
  
  private JSONArray u = new JSONArray();
  

  private static String v = null;
  
  private static String w;
  private static a x = null;
  
  private int y = 0;
  
  private PhoneStateListener z = new PhoneStateListener()
  {
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
      super.onSignalStrengthsChanged(signalStrength);
      if (signalStrength.isGsm()) {
        if (signalStrength.getGsmSignalStrength() != 99) {
          a.a(a.this, signalStrength.getGsmSignalStrength() * 2 - 113);
        } else {
          a.a(a.this, signalStrength.getGsmSignalStrength());
        }
      } else {
        a.a(a.this, signalStrength.getCdmaDbm());
      }
    }
  };
  
  public static a a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, o paramO) {
    if (x == null) {
      x = new a(paramContext, paramString1, paramString2, paramString3, paramString4, paramO);
    }
    return x;
  }
  
  public static a b() {
    if ((x == null) && 
      (b.a)) { Log.d("APIClient", "Error initializing KiipSDK");
    }
    return x;
  }
  
  a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, o paramO) {
    h = paramString1;
    i = paramString3;
    j = paramString4;
    e = paramO;
    m = paramContext;
    b = new Handler();
    

    f = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    g = ((LocationManager)paramContext.getSystemService("location"));
    

    JSONObject localJSONObject1 = n;
    try {
      localJSONObject1.put("app_key", paramString3);
      localJSONObject1.put("versionCode", me.kiip.internal.g.b.a(paramContext));
      localJSONObject1.put("versionName", me.kiip.internal.g.b.b(paramContext));
      

      localJSONObject1.put("version", me.kiip.internal.g.b.a(paramContext) + " " + me.kiip.internal.g.b.b(paramContext));
    } catch (JSONException localJSONException1) {
      if (b.a) { Log.e("APIClient", "Unexpected exception", localJSONException1);
      }
    }
    
    JSONObject localJSONObject2 = o;
    try {
      localJSONObject2.put("name", "Kiip Android");
      localJSONObject2.put("version", paramString2);
      localJSONObject2.put("testMode", l);
    } catch (JSONException localJSONException2) {
      if (b.a) { Log.e("APIClient", "Unexpected exception", localJSONException2);
      }
    }
    
    JSONObject localJSONObject3 = p;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    me.kiip.internal.g.e.a(paramContext, localDisplayMetrics);
    w = d.a(paramContext);
    try {
      localJSONObject3.put("kiip_uuid", w);
      localJSONObject3.put("manufacturer", Build.MANUFACTURER);
      localJSONObject3.put("model", Build.MODEL);
      localJSONObject3.put("os", "Android " + Build.VERSION.RELEASE);
      localJSONObject3.put("lang", Locale.getDefault().getLanguage());
      localJSONObject3.put("locale", Locale.getDefault().toString());
      localJSONObject3.put("timezone", TimeZone.getDefault().getID());
      localJSONObject3.put("resolution", widthPixels + "x" + heightPixels);
      localJSONObject3.put("density", density);
      String str = System.getProperty("http.agent");
      localJSONObject3.put("user_agent", str.substring(0, Math.min(str.length(), 240)));
    } catch (JSONException localJSONException3) {
      if (b.a) { Log.e("APIClient", "Unexpected exception", localJSONException3);
      }
    }
    








    JSONObject localJSONObject4 = q;
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    try {
      if (Build.VERSION.SDK_INT >= 14) {
        localTelephonyManager.listen(z, 256);
        localJSONObject4.put("signal", y);
      }
      localJSONObject4.put("carrier", localTelephonyManager.getNetworkOperatorName());
    } catch (JSONException localJSONException4) {
      if (b.a) Log.e("APIClient", "Unexpected exception", localJSONException4);
    } catch (NullPointerException localNullPointerException) {
      if (b.a) { Log.e("APIClient", "Unexpected exception", localNullPointerException);
      }
    }
  }
  




  public o c()
  {
    return e;
  }
  
  public String d() {
    return p.optString("id");
  }
  





  public void a(String paramString)
  {
    k = paramString;
  }
  



  public String e()
  {
    return k;
  }
  
  public void a(String[] paramArrayOfString) {
    JSONArray localJSONArray = new JSONArray();
    for (String str : paramArrayOfString) {
      localJSONArray.put(str);
    }
    try {
      o.put("capabilities", localJSONArray);
    } catch (JSONException localJSONException) {
      if (b.a) Log.e("APIClient", "Unexpected exception", localJSONException);
    }
  }
  
  public String[] f() {
    String[] arrayOfString = null;
    JSONArray localJSONArray = o.optJSONArray("capabilities");
    
    if (localJSONArray != null) {
      arrayOfString = new String[localJSONArray.length()];
      for (int i1 = 0; i1 < localJSONArray.length(); i1++) {
        arrayOfString[i1] = localJSONArray.optString(i1);
      }
    }
    
    return arrayOfString;
  }
  
  void b(String paramString) {
    try {
      o.put("wrapper", paramString);
    } catch (JSONException localJSONException) {
      if (b.a) Log.e("APIClient", "Unexpected exception", localJSONException);
    }
  }
  
  public String g() {
    if (r.isNull("gender")) {
      return null;
    }
    return r.optString("gender");
  }
  
  public void c(String paramString) {
    try {
      r.put("gender", paramString);
    } catch (JSONException localJSONException) {
      if (b.a) Log.e("APIClient", "Unexpected exception", localJSONException);
    }
  }
  
  public String h() {
    if (r.isNull("userid")) {
      return null;
    }
    return r.optString("userid");
  }
  
  public void d(String paramString) {
    try {
      r.put("userid", paramString);
    } catch (JSONException localJSONException) {
      if (b.a) Log.e("APIClient", "Unexpected exception", localJSONException);
    }
  }
  
  public Date i() {
    Date localDate = null;
    
    if (!r.isNull("birthday")) {
      try {
        String str = r.optString("birthday");
        localDate = a.parse(str);
      }
      catch (ParseException localParseException) {}
    }
    

    return localDate;
  }
  
  public void a(Date paramDate) {
    try {
      r.put("birthday", paramDate != null ? a.format(paramDate) : null);
    } catch (JSONException localJSONException) {
      if (b.a) Log.e("APIClient", "Unexpected exception", localJSONException);
    }
  }
  
  public String j() {
    if (r.isNull("ages")) {
      return null;
    }
    return r.optString("ages");
  }
  
  public void e(String paramString) {
    try {
      r.put("ages", paramString);
    } catch (JSONException localJSONException) {
      if (b.a) Log.e("APIClient", "Unexpected exception", localJSONException);
    }
  }
  
  public void a(Boolean paramBoolean) {
    try {
      l = paramBoolean;
      o.put("testMode", l);
    } catch (JSONException localJSONException) {
      if (b.a) Log.e("APIClient", "Unexpected exception", localJSONException);
    }
  }
  
  public Boolean k() {
    return l;
  }
  



  private void a(Location paramLocation)
  {
    if (t == null) {
      t = new JSONObject();
    }
    try
    {
      t.put("lat", paramLocation.getLatitude());
      t.put("lng", paramLocation.getLongitude());
      t.put("accuracy", paramLocation.getAccuracy());
      t.put("time", a.format(Long.valueOf(paramLocation.getTime())));
    } catch (JSONException localJSONException) {
      if (b.a) { Log.e("APIClient", "Unexpected exception", localJSONException);
      }
    }
  }
  

  public n a(final a paramA)
  {
    JSONObject localJSONObject = new JSONObject();
    String str1 = "";
    

    try
    {
      if (s != null) {
        String str2 = d.a(m, "applist_sha1sum");
        str1 = d.a(s.toString());
        if (!str1.equals(str2)) {
          localJSONObject.put("meta", s);
        } else {
          str1 = "";
        }
      }
      Log.d("APIClient", "currentSum " + str1);
    } catch (JSONException localJSONException) {
      if (b.a) { Log.e("APIClient", "Unexpected exception", localJSONException);
      }
    }
    final String str3 = str1;
    a local3 = new a()
    {
      public void a(JSONObject paramAnonymousJSONObject) {
        if (!str3.equals("")) {
          d.a(a.a(a.this), "applist_sha1sum", str3);
        }
        if (paramA != null) {
          paramA.a(paramAnonymousJSONObject);
        }
      }
      
      public void a(Exception paramAnonymousException) {
        if (paramA != null) {
          paramA.a(paramAnonymousException);
        }
        
      }
    };
    return a("POST", "/app/cache", localJSONObject, local3);
  }
  
  public n a(String paramString, Double paramDouble, f paramF, a paramA)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    
    if (paramF != null) {
      localJSONObject2 = f.a(paramF);
    }
    try
    {
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("id", paramString);
      localJSONObject3.put("value", paramDouble);
      localJSONObject3.put("meta", localJSONObject2);
      localJSONObject1.put("moment", localJSONObject3);
    } catch (JSONException localJSONException) {
      if (b.a) { Log.e("APIClient", "Unexpected exception", localJSONException);
      }
    }
    if (b.a) { Log.d("APIClient", "saveMoment " + localJSONObject1);
    }
    return a("POST", "/moment/save", localJSONObject1, paramA);
  }
  
  public void a(String paramString, Long paramLong1, Long paramLong2, Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    try {
      localJSONObject.put("id", paramString);
      localJSONObject.put("start", paramLong1 != null ? a.format(paramLong1) : null);
      localJSONObject.put("end", paramLong2 != null ? a.format(paramLong2) : null);
      
      if (paramBundle != null) {
        for (String str : paramBundle.keySet()) {
          localJSONObject.put(str, paramBundle.get(str));
        }
      }
    } catch (JSONException localJSONException) {
      if (b.a) { Log.e("APIClient", "Unexpected exception", localJSONException);
      }
    }
    u.put(localJSONObject);
    if (b.a) { Log.d("APIClient", "Queued event: " + localJSONObject.toString() + " size=" + u.length());
    }
    
    b.removeCallbacks(c);
    b.postDelayed(c, 30000L);
  }
  
  public n b(a paramA) {
    if (b.a) { Log.d("APIClient", "Flushing events: " + u.length());
    }
    return a("POST", "/event/save", (JSONObject)null, paramA);
  }
  
  private n a(String paramString1, String paramString2, JSONObject paramJSONObject, final a paramA)
  {
    b.removeCallbacks(c);
    
    Date localDate = new Date();
    final String str1 = h + paramString2;
    JSONObject localJSONObject = new JSONObject();
    final JSONArray localJSONArray = new JSONArray();
    

    int i1 = u.length();
    for (int i2 = 0; i2 < i1; i2++) {
      localJSONArray.put(u.opt(i2));
    }
    

    u = new JSONArray();
    

    m();
    n();
    try
    {
      localJSONObject.put("session_id", k);
      localJSONObject.put("date", a.format(localDate));
      localJSONObject.put("source", "application");
      
      localJSONObject.put("app", n);
      localJSONObject.put("sdk", o);
      localJSONObject.put("location", t);
      if (!p.has("advertising_identifier")) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
          p.put("advertising_identifier", l());
        }
        p.put("id", v == null ? w : v);
      }
      localJSONObject.put("device", p);
      localJSONObject.put("connection", q);
      localJSONObject.put("user", r);
      localJSONObject.put("events", localJSONArray);
      if (paramJSONObject != null) {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext()) {
          String str2 = (String)localIterator.next();
          localJSONObject.put(str2, paramJSONObject.get(str2));
        }
      }
    } catch (JSONException localJSONException1) {
      if (b.a) { Log.e("APIClient", "Unexpected exception", localJSONException1);
      }
    }
    me.kiip.internal.j.a localA = new me.kiip.internal.j.a(1, str1, localJSONObject, new p.b()
    









      new p.a
      {
        public void a(JSONObject paramAnonymousJSONObject) {
          if (b.a) {
            try {
              Log.d("APIClient", "Request finished " + str1 + " " + paramAnonymousJSONObject.toString(4));
            }
            catch (Exception localException) {}
          }
          
          if (paramA != null)
            paramA.a(paramAnonymousJSONObject); } }, new p.a()
      {

        public void a(u paramAnonymousU)
        {

          if (b.a) { Log.d("APIClient", "Request failed " + str1 + " " + paramAnonymousU.getMessage(), paramAnonymousU);
          }
          


          int i = localJSONArray.length();
          for (int j = 0; j < i; j++) {
            a.b(a.this).put(localJSONArray.opt(j));
          }
          
          if (paramA != null) {
            paramA.a(paramAnonymousU);
          }
        }
      });
    localA.a(i, j);
    
    localA.a(new me.kiip.internal.a.e(30000, 1, 1.0F));
    


    if (b.a) {
      try {
        Log.d("APIClient", "headers: " + localA.g());
        Log.d("APIClient", "request: " + str1 + " " + localJSONObject.toString(4));
      }
      catch (me.kiip.internal.a.a localA1) {}catch (JSONException localJSONException2) {}
    }
    



    e.a(localA);
    return localA;
  }
  
  private void m() {
    try {
      JSONObject localJSONObject = q;
      localJSONObject.put("type", c.a(f));
    } catch (JSONException localJSONException) {
      if (b.a) Log.e("APIClient", "Unexpected exception", localJSONException);
    }
  }
  
  private void n() {
    try {
      Location localLocation = me.kiip.internal.g.f.a(g, (float)(System.currentTimeMillis() - 86400000L));
      if (localLocation != null) {
        a(localLocation);
      }
    } catch (SecurityException localSecurityException) {
      if (b.a) Log.w("APIClient", "Allow permissions ACCESS_FINE_LOCATION or ACCESS_COARSE_LOCATION to receive location updates");
    }
  }
  
  public String l() {
    try {
      me.kiip.internal.g.a.a localA = me.kiip.internal.g.a.a(m);
      String str = localA.a();
      boolean bool = localA.b();
      if (!bool) {
        v = str;
        return str;
      }
    } catch (Exception localException) {
      Log.d("APIClient", "Unexpected exception.", localException);
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void a(JSONObject paramJSONObject);
    
    public abstract void a(Exception paramException);
  }
}
