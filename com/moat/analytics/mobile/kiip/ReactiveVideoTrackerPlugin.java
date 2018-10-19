package com.moat.analytics.mobile.kiip;

import android.app.Activity;
import android.view.View;
import com.moat.analytics.mobile.kiip.base.functional.Optional;
import java.util.Map;







public class ReactiveVideoTrackerPlugin
  implements m<ReactiveVideoTracker>
{
  private final String ˋ;
  
  public ReactiveVideoTrackerPlugin(String paramString)
  {
    ˋ = paramString;
  }
  







  public ReactiveVideoTracker create()
    throws o
  {
    (ReactiveVideoTracker)s.ˊ(new s.a()
    {
      public final Optional<ReactiveVideoTracker> ˏ()
      {
        b.ˎ("[INFO] ", "Attempting to create ReactiveVideoTracker");
        
        return Optional.of(new w(ReactiveVideoTrackerPlugin.ˎ(ReactiveVideoTrackerPlugin.this)));
      }
      
    }, ReactiveVideoTracker.class);
  }
  
  public ReactiveVideoTracker createNoOp()
  {
    return new b();
  }
  

  static class b
    implements ReactiveVideoTracker
  {
    b() {}
    

    public final void setActivity(Activity paramActivity) {}
    
    public final void setListener(TrackerListener paramTrackerListener) {}
    
    public final void removeListener() {}
    
    public final void setVideoListener(VideoTrackerListener paramVideoTrackerListener) {}
    
    public final void removeVideoListener() {}
    
    public final boolean trackVideoAd(Map<String, String> paramMap, Integer paramInteger, View paramView)
    {
      return false;
    }
    
    public final void setPlayerVolume(Double paramDouble) {}
    
    public final void changeTargetView(View paramView) {}
    
    public final void dispatchEvent(MoatAdEvent paramMoatAdEvent) {}
    
    public final void stopTracking() {}
  }
}
