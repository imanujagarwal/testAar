package me.kiip.internal.l;

import android.annotation.TargetApi;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.webkit.WebView;

public class c
{
  public static void a(WebView paramWebView, int paramInt, Paint paramPaint)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      a.a(paramWebView, paramInt, paramPaint);
    }
  }
  


  @TargetApi(11)
  private static class a
  {
    static void a(WebView paramWebView, int paramInt, Paint paramPaint)
    {
      paramWebView.setLayerType(paramInt, paramPaint);
    }
  }
}
