package com.moat.analytics.mobile.kiip;

import android.app.Activity;
import android.app.Application;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import java.util.Map;













abstract class NoOp
{
  NoOp() {}
  
  static class b
    implements WebAdTracker
  {
    b() {}
    
    public final void startTracking() {}
    
    public final void setListener(TrackerListener paramTrackerListener) {}
    
    public final void removeListener() {}
    
    public final void setActivity(Activity paramActivity) {}
    
    public final void stopTracking() {}
  }
  
  static class a
    implements NativeDisplayTracker
  {
    a() {}
    
    public final void startTracking() {}
    
    public final void setListener(TrackerListener paramTrackerListener) {}
    
    public final void removeListener() {}
    
    public final void setActivity(Activity paramActivity) {}
    
    public final void stopTracking() {}
    
    public final void reportUserInteractionEvent(NativeDisplayTracker.MoatUserInteractionType paramMoatUserInteractionType) {}
  }
  
  static class c
    implements NativeVideoTracker
  {
    c() {}
    
    public final void setActivity(Activity paramActivity) {}
    
    public final void setListener(TrackerListener paramTrackerListener) {}
    
    public final void removeListener() {}
    
    public final void setVideoListener(VideoTrackerListener paramVideoTrackerListener) {}
    
    public final void removeVideoListener() {}
    
    public final void dispatchEvent(MoatAdEvent paramMoatAdEvent) {}
    
    public final boolean trackVideoAd(Map<String, String> paramMap, MediaPlayer paramMediaPlayer, View paramView)
    {
      return false;
    }
    

    public final void setPlayerVolume(Double paramDouble) {}
    

    public final void changeTargetView(View paramView) {}
    
    public final void stopTracking() {}
  }
  
  public static class MoatAnalytics
    extends MoatAnalytics
  {
    public MoatAnalytics() {}
    
    public void start(MoatOptions paramMoatOptions, Application paramApplication) {}
    
    public void start(Application paramApplication) {}
    
    public void prepareNativeDisplayTracking(String paramString) {}
  }
  
  public static class MoatFactory
    extends MoatFactory
  {
    public MoatFactory() {}
    
    public WebAdTracker createWebAdTracker(@NonNull WebView paramWebView)
    {
      return new NoOp.b();
    }
    
    public WebAdTracker createWebAdTracker(@NonNull ViewGroup paramViewGroup)
    {
      return new NoOp.b();
    }
    
    public NativeDisplayTracker createNativeDisplayTracker(@NonNull View paramView, @NonNull Map<String, String> paramMap)
    {
      return new NoOp.a();
    }
    
    public NativeVideoTracker createNativeVideoTracker(@NonNull String paramString)
    {
      return new NoOp.c();
    }
    
    public <T> T createCustomTracker(m<T> paramM)
    {
      return paramM.createNoOp();
    }
  }
}
