package me.kiip.sdk;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.Date;
import me.kiip.internal.e.e;
import me.kiip.internal.e.f;





















public abstract class Kiip
{
  public static final String VERSION = "3.0.1";
  public static final String CAPABILITY_REAL = "real";
  public static final String CAPABILITY_VIRTUAL = "virtual";
  public static final String CAPABILITY_VIDEO = "video";
  public static final String CAPABILITY_SHARE = "share";
  public static final String CAPABILITY_AUGMENTED_REALITY = "ar";
  private static Kiip a;
  
  public static Kiip getInstance()
  {
    return a;
  }
  





















  public static void init(Application application, String appKey, String appSecret)
  {
    if (a == null) {
      a = e.a(application, appKey, appSecret);
    }
  }
  
  protected Kiip() {}
  
  public abstract void setWrapper(String paramString);
  
  public abstract String getEmail();
  
  public abstract void setEmail(String paramString);
  
  public abstract String getGender();
  
  public abstract void setGender(String paramString);
  
  public abstract Date getBirthday();
  
  public abstract void setBirthday(Date paramDate);
  
  public abstract AgeGroup getAgeGroup();
  
  public abstract void setAgeGroup(AgeGroup paramAgeGroup);
  
  public abstract String getUserId();
  
  public abstract void setUserId(String paramString);
  
  public abstract void setTestMode(Boolean paramBoolean);
  
  public abstract Boolean getTestMode();
  
  public abstract void setCapabilities(String[] paramArrayOfString);
  
  public abstract String[] getCapabilities();
  
  public abstract void setAdapter(KiipAdapter paramKiipAdapter);
  
  public abstract void setOnContentListener(OnContentListener paramOnContentListener);
  
  public abstract String getDeviceIdentifier();
  
  public abstract boolean startSession(Callback paramCallback);
  
  public abstract boolean endSession(Callback paramCallback);
  
  public abstract void saveMoment(String paramString, Callback paramCallback);
  
  public abstract void saveMoment(String paramString, double paramDouble, Callback paramCallback);
  
  public abstract void saveMoment(String paramString, f paramF, Callback paramCallback);
  
  public abstract void onRequestPermissionResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public static abstract interface OnContentListener
  {
    public abstract void onContent(String paramString1, int paramInt, String paramString2, String paramString3);
  }
  
  public static abstract interface KiipAdapter
  {
    public abstract View getNotificationView(Context paramContext, ViewGroup paramViewGroup, Poptart paramPoptart);
  }
  
  public static abstract interface Callback
  {
    public abstract void onFailed(Kiip paramKiip, Exception paramException);
    
    public abstract void onFinished(Kiip paramKiip, Poptart paramPoptart);
  }
  
  public static enum AgeGroup
  {
    private AgeGroup() {}
  }
}
