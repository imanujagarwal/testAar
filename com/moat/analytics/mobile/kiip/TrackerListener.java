package com.moat.analytics.mobile.kiip;

public abstract interface TrackerListener
{
  public abstract void onTrackingStarted(String paramString);
  
  public abstract void onTrackingFailedToStart(String paramString);
  
  public abstract void onTrackingStopped(String paramString);
}
