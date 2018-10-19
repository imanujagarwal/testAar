package me.kiip.internal.e;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.text.format.DateUtils;
import android.util.Log;
import com.moat.analytics.mobile.kiip.MoatAnalytics;
import com.moat.analytics.mobile.kiip.MoatOptions;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import me.kiip.internal.a.k;
import me.kiip.internal.a.n;
import me.kiip.internal.a.p;
import me.kiip.internal.a.p.a;
import me.kiip.internal.b.c;
import me.kiip.internal.b.j;
import me.kiip.internal.h.i;
import me.kiip.internal.h.i.a;
import me.kiip.sdk.Kiip;
import me.kiip.sdk.Kiip.AgeGroup;
import me.kiip.sdk.Kiip.Callback;
import me.kiip.sdk.Kiip.KiipAdapter;
import me.kiip.sdk.Kiip.OnContentListener;
import me.kiip.sdk.KiipRuntimeException;
import me.kiip.sdk.Poptart;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;







public final class e
  extends Kiip
{
  private static final boolean d = b.a;
  











  public static e a(Application paramApplication, String paramString1, String paramString2)
  {
    return new e(paramApplication, paramString1, paramString2);
  }
  

  private boolean e = true;
  private LinkedList<String> f = new LinkedList();
  
  Handler a;
  private final Runnable g = new Runnable()
  {
    public void run() {
      e.a(e.this, null);
    }
  };
  private Kiip.Callback h;
  private final Runnable i = new Runnable()
  {
    public void run() {
      e.b(e.this, e.a(e.this));
      e.c(e.this, null);
    }
  };
  
  private Context j;
  
  private final SharedPreferences k;
  private me.kiip.internal.a.o l;
  a b;
  i c;
  private int m = 0;
  

  private long n;
  

  private Long o = Long.valueOf(0L);
  
  private static Handler p;
  
  private e(Application paramApplication, String paramString1, String paramString2)
  {
    if (b.a) { Log.d("KiipImpl", "[DEBUG] Instantiating Kiip appKey=" + paramString1 + " appSecret=" + paramString2);
    }
    j = paramApplication;
    a = new Handler();
    k = paramApplication.getSharedPreferences("me.kiip.sdk", 0);
    


    try
    {
      l = me.kiip.internal.b.o.a(paramApplication);
      
      File localFile = new File(paramApplication.getCacheDir(), "me.kiip.sdk/https");
      me.kiip.internal.b.e localE = new me.kiip.internal.b.e(localFile, 4194304);
      

      c localC = new c(new j());
      
      l = new me.kiip.internal.a.o(localE, localC);
      l.a();
    } catch (Exception localException) {
      Log.d("KiipImpl", "Exception while initalizing cache.");
    }
    
    b = a.a(paramApplication, "https://api.kiip.me/2.0", "3.0.1", paramString1, paramString2, l);
    c = new i(b);
    

    new Thread(g).start();
    
    a(false);
    b();
    a();
  }
  
  private void a()
  {
    MoatOptions localMoatOptions = new MoatOptions();
    loggingEnabled = true;
    disableAdIdCollection = true;
    disableLocationServices = true;
    autoTrackGMAInterstitials = true;
    MoatAnalytics.getInstance().start(localMoatOptions, (Application)j);
  }
  
  private void a(JSONObject paramJSONObject) {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("moments");
    boolean bool1 = (localJSONObject == null) || (localJSONObject.optBoolean("enabled", true));
    Object localObject = localJSONObject != null ? localJSONObject.optJSONArray("blacklist") : null;
    JSONArray localJSONArray = paramJSONObject.optJSONArray("urls");
    int i1 = paramJSONObject.optInt("quiet_period", 0);
    boolean bool2 = paramJSONObject.optBoolean("debug", false);
    
    SharedPreferences.Editor localEditor = k.edit();
    localEditor.putBoolean("moments.enabled", bool1);
    localEditor.putString("moments.blacklist", localObject != null ? localObject.toString() : null);
    localEditor.putString("urls", localJSONArray != null ? localJSONArray.toString() : null);
    localEditor.putInt("quiet.period", i1);
    localEditor.putBoolean("debug", bool2);
    localEditor.putLong("last.saved.time.milliseconds", c().longValue());
    localEditor.commit();
  }
  


  private void a(boolean paramBoolean)
  {
    e = k.getBoolean("moments.enabled", true);
    o = Long.valueOf(k.getLong("last.saved.time.milliseconds", 0L));
    int i1;
    int i2;
    try {
      if (k.getString("moments.blacklist", "[]") != "[]") {
        JSONArray localJSONArray1 = new JSONArray(k.getString("moments.blacklist", "[]"));
        i1 = localJSONArray1.length();
        for (i2 = 0; i2 < i1; i2++) {
          f.add(localJSONArray1.optString(i2));
        }
      }
    } catch (JSONException localJSONException1) {
      if (b.a) { Log.d("KiipImpl", "Unexpected exception", localJSONException1);
      }
    }
    
    if (paramBoolean) {
      try {
        if (k.getString("urls", "") != "") {
          JSONArray localJSONArray2 = new JSONArray(k.getString("urls", ""));
          i1 = localJSONArray2.length();
          for (i2 = 0; i2 < i1; i2++) {
            a(localJSONArray2.optString(i2));
          }
        }
        


        b.a = k.getBoolean("debug", false);
      }
      catch (JSONException localJSONException2) {
        if (b.a) { Log.d("KiipImpl", "Unexpected exception", localJSONException2);
        }
      }
    }
    if (b.a) { Log.d("KiipImpl", "Preferences: enabled=" + e + " blacklist=" + f);
    }
  }
  

  public void setWrapper(String wrapper)
  {
    b.b(wrapper);
  }
  
  public String getEmail()
  {
    return c.b();
  }
  
  public void setEmail(String email)
  {
    c.a(email);
  }
  
  public String getUserId()
  {
    return b.h();
  }
  
  public void setUserId(String userId)
  {
    b.d(userId);
  }
  
  public String getGender()
  {
    return b.g();
  }
  
  public void setGender(String gender)
  {
    b.c(gender);
  }
  
  public Date getBirthday()
  {
    return b.i();
  }
  
  public void setBirthday(Date birthday)
  {
    b.a(birthday);
  }
  
  public Kiip.AgeGroup getAgeGroup()
  {
    Kiip.AgeGroup localAgeGroup = null;
    String str = b.j();
    
    if (str != null) {
      if (str.equals("13-17")) {
        localAgeGroup = Kiip.AgeGroup.AGE_GROUP_13_TO_17;
      } else if (str.equals("18-34")) {
        localAgeGroup = Kiip.AgeGroup.AGE_GROUP_18_TO_34;
      } else if (str.equals("35-49")) {
        localAgeGroup = Kiip.AgeGroup.AGE_GROUP_35_TO_49;
      } else if (str.equals("50")) {
        localAgeGroup = Kiip.AgeGroup.AGE_GROUP_50;
      }
    }
    
    return localAgeGroup;
  }
  
  public void setAgeGroup(Kiip.AgeGroup agegroup)
  {
    String str = "";
    switch (8.a[agegroup.ordinal()]) {
    case 1: 
      str = "13-17";
      break;
    case 2: 
      str = "18-34";
      break;
    case 3: 
      str = "35-49";
      break;
    case 4: 
      str = "50";
      break;
    }
    
    
    b.e(str);
  }
  
  public Boolean getTestMode()
  {
    return b.k();
  }
  
  public void setTestMode(Boolean testMode)
  {
    b.a(testMode);
  }
  
  public void setCapabilities(String[] capabilities)
  {
    b.a(capabilities);
  }
  
  public String[] getCapabilities()
  {
    return b.f();
  }
  
  public void setAdapter(Kiip.KiipAdapter adapter)
  {
    c.a(adapter);
  }
  
  public void setOnContentListener(Kiip.OnContentListener listener)
  {
    c.a(listener);
    b();
  }
  
  public String getDeviceIdentifier()
  {
    return b.d();
  }
  


  private void a(final Kiip.Callback paramCallback)
  {
    b.a(new a.a()
    {
      public void a(Exception paramAnonymousException) {
        if (b.a) { Log.e("KiipImpl", "/app/cache failed", paramAnonymousException);
        }
        if (paramCallback != null) {
          paramCallback.onFailed(e.this, paramAnonymousException);
        }
      }
      
      public void a(JSONObject paramAnonymousJSONObject)
      {
        if (b.a) Log.d("KiipImpl", "/app/cache finished");
        a(paramAnonymousJSONObject, new i.a()
        {
          public void a(i paramAnonymous2I, Poptart paramAnonymous2Poptart, Exception paramAnonymous2Exception) {
            if ((paramAnonymous2Exception != null) && 
              (b.a)) { Log.e("KiipImpl", "Error loading poptart", paramAnonymous2Exception);
            }
            
            if (a != null) {
              a.onFinished(e.this, paramAnonymous2Poptart);
            }
          }
        });
      }
    });
  }
  
  public void saveMoment(String id, Kiip.Callback callback)
  {
    a(id, null, null, callback);
  }
  
  public void saveMoment(String id, double value, Kiip.Callback callback)
  {
    a(id, Double.valueOf(value), null, callback);
  }
  
  public void saveMoment(String id, f mm, Kiip.Callback callback) {
    a(id, null, mm, callback);
  }
  
  private void a(String paramString, Double paramDouble, f paramF, final Kiip.Callback paramCallback) {
    if (!e) {
      paramCallback.onFailed(this, new KiipRuntimeException("This application has been disabled"));
      return;
    }
    
    if ((f != null) && (f.contains(paramString))) {
      paramCallback.onFailed(this, new KiipRuntimeException("This moment has been disabled"));
      return;
    }
    
    b.a(paramString, paramDouble, paramF, new a.a()
    {
      public void a(Exception paramAnonymousException) {
        if (paramCallback != null) {
          paramCallback.onFailed(e.this, paramAnonymousException);
        }
      }
      
      public void a(JSONObject paramAnonymousJSONObject)
      {
        a(paramAnonymousJSONObject, new i.a()
        {
          public void a(i paramAnonymous2I, Poptart paramAnonymous2Poptart, Exception paramAnonymous2Exception) {
            if ((paramAnonymous2Exception != null) && 
              (b.a)) { Log.e("KiipImpl", "Error loading poptart", paramAnonymous2Exception);
            }
            
            if (a != null) {
              a.onFinished(e.this, paramAnonymous2Poptart);
            }
          }
        });
      }
    });
  }
  
  public static void a(Handler paramHandler) {
    p = paramHandler;
  }
  
  public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults)
  {
    switch (requestCode) {
    case 5001: 
      if ((grantResults.length > 0) && (grantResults[0] == 0)) {
        if (p != null) {
          p.sendEmptyMessage(1);
        }
      }
      else if (p != null) {
        p.sendEmptyMessage(0);
      }
      break;
    }
    
  }
  
  public boolean startSession(final Kiip.Callback callback)
  {
    m += 1;
    if (m > 1)
    {
      if (callback != null) {
        callback.onFinished(null, null);
      }
      return false;
    }
    
    if (h != null) {
      h.onFinished(null, null);
      h = null;
    }
    
    a.removeCallbacks(g);
    a.removeCallbacks(i);
    
    if (b.e() != null)
    {
      callback.onFinished(null, null);
      return false;
    }
    
    if (b.a) { Log.d("KiipImpl", "start session");
    }
    if ((ContextCompat.checkSelfPermission(j, "android.permission.CAMERA") == 0) && 
      (p != null)) {
      p.sendEmptyMessage(1);
    }
    


    b.a(a.a());
    n = c().longValue();
    b.a("session_start", Long.valueOf(n), null, null);
    int i1 = k.getInt("quiet.period", 0);
    if ((i1 == 0) || (a(i1)))
    {




      new Thread(new Runnable()
      {
        public void run()
        {
          e.a(e.this, callback);
        }
      })
      



        .start();
    }
    return true;
  }
  
  public boolean endSession(Kiip.Callback callback)
  {
    m -= 1;
    if (m > 0)
    {
      if (callback != null) {
        callback.onFinished(null, null);
      }
      return false;
    }
    
    m = 0;
    
    h = callback;
    a.postDelayed(i, 2000L);
    
    return true;
  }
  
  private void b(final Kiip.Callback paramCallback) {
    if (b.a) { Log.d("KiipImpl", "end session");
    }
    b.a("session_end", Long.valueOf(n), Long.valueOf(System.currentTimeMillis()), null);
    b.b(new a.a()
    {
      public void a(Exception paramAnonymousException) {
        if (paramCallback != null) {
          paramCallback.onFailed(e.this, paramAnonymousException);
        }
      }
      
      public void a(JSONObject paramAnonymousJSONObject)
      {
        if (paramCallback != null) {
          paramCallback.onFinished(e.this, null);
        }
        
      }
      
    });
    b.a(null);
  }
  
  void a(JSONObject paramJSONObject, i.a paramA) {
    if (paramJSONObject != null) {
      JSONObject localJSONObject1 = paramJSONObject.optJSONObject("cache");
      JSONObject localJSONObject2 = paramJSONObject.optJSONObject("view");
      
      if (localJSONObject1 != null)
      {
        a(localJSONObject1);
        a(true);
      }
      
      if (localJSONObject2 != null) {
        c.a(localJSONObject2, paramA);
      } else {
        String str = k.getString("view", "");
        if (str != "") {
          try {
            JSONObject localJSONObject3 = new JSONObject(str);
            if (localJSONObject3.has("last_cache_date")) {
              Calendar localCalendar1 = Calendar.getInstance();
              SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
              localCalendar1.setTime(localSimpleDateFormat.parse(localJSONObject3.getString("last_cache_date")));
              localCalendar1.add(11, 4);
              Calendar localCalendar2 = Calendar.getInstance();
              if (localCalendar1.after(localCalendar2)) {
                if (b.a) Log.d("KiipImpl", "show cached reward.");
                c.a(localJSONObject3, paramA);
              } else {
                SharedPreferences.Editor localEditor = k.edit();
                localEditor.remove("view");
                localEditor.apply();
              }
            }
          } catch (Exception localException) {
            if (b.a) Log.d("KiipImpl", localException.toString());
          }
        } else {
          paramA.a(null, null, null);
        }
      }
    } else {
      paramA.a(null, null, null);
    }
  }
  



  private void a(String paramString)
  {
    if (b.a) { Log.d("KiipImpl", "cacheUrl " + paramString);
    }
    
    if (Uri.parse(paramString).getHost() == null) {
      return;
    }
    
    n local7 = new n(0, paramString, null)
    {
      protected p<byte[]> a(k paramAnonymousK) {
        if (b.a) Log.d("KiipImpl", "headers=" + c);
        return p.a(b, me.kiip.internal.b.g.a(paramAnonymousK));
      }
      
      protected void a(byte[] paramAnonymousArrayOfByte)
      {
        if (b.a) {
          me.kiip.internal.a.b localB = e.b(e.this).d();
        }
        
      }
      

    };
    l.a(local7);
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("real");
    localArrayList.add("share");
    localArrayList.add("video");
    

    if (c.c() != null) {
      localArrayList.add("virtual");
    }
    
    if (me.kiip.internal.g.g.a(j).a()) {
      localArrayList.add("ar");

    }
    else if (b.a) { Log.d("KiipImpl", "Either Accelerometer or Magnetic Field sensors not available");
    }
    b.a((String[])localArrayList.toArray(new String[0]));
  }
  


  private boolean a(int paramInt)
  {
    Long localLong1 = c();
    Long localLong2 = Long.valueOf(Long.valueOf(paramInt).longValue() * 60000L);
    
    return (!DateUtils.isToday(o.longValue())) || (localLong1.longValue() - o.longValue() > localLong2.longValue());
  }
  
  private Long c()
  {
    return Long.valueOf(System.currentTimeMillis());
  }
}
