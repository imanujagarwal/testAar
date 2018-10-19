package com.moat.analytics.mobile.kiip;

import android.app.Application;
import android.support.annotation.UiThread;





public abstract class MoatAnalytics
{
  public MoatAnalytics() {}
  
  private static MoatAnalytics ˎ = null;
  
  public static synchronized MoatAnalytics getInstance() {
    if (ˎ == null)
      try {
        ˎ = new j();
      } catch (Exception localException) {
        o.ॱ(
        
          localException);ˎ = new NoOp.MoatAnalytics();
      }
    return ˎ;
  }
  
  public abstract void start(MoatOptions paramMoatOptions, Application paramApplication);
  
  public abstract void start(Application paramApplication);
  
  @UiThread
  public abstract void prepareNativeDisplayTracking(String paramString);
}
