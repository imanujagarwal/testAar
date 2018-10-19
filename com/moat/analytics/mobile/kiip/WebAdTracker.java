package com.moat.analytics.mobile.kiip;

import android.app.Activity;
import android.support.annotation.UiThread;

@UiThread
public abstract interface WebAdTracker
{
  public abstract void setListener(TrackerListener paramTrackerListener);
  
  public abstract void removeListener();
  
  @Deprecated
  public abstract void setActivity(Activity paramActivity);
  
  public abstract void startTracking();
  
  public abstract void stopTracking();
}
