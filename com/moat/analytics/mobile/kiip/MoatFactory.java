package com.moat.analytics.mobile.kiip;

import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import java.util.Map;




public abstract class MoatFactory
{
  public MoatFactory() {}
  
  public static MoatFactory create()
  {
    try
    {
      return new n();
    } catch (Exception localException) {
      o.ॱ(localException;
    }
    return new NoOp.MoatFactory();
  }
  
  @UiThread
  public abstract WebAdTracker createWebAdTracker(@NonNull WebView paramWebView);
  
  @UiThread
  public abstract WebAdTracker createWebAdTracker(@NonNull ViewGroup paramViewGroup);
  
  @UiThread
  public abstract NativeDisplayTracker createNativeDisplayTracker(@NonNull View paramView, @NonNull Map<String, String> paramMap);
  
  @UiThread
  public abstract NativeVideoTracker createNativeVideoTracker(String paramString);
  
  @UiThread
  public abstract <T> T createCustomTracker(m<T> paramM);
}
