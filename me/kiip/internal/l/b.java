package me.kiip.internal.l;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.webkit.WebSettings;

public class b
{
  public static void a(WebSettings paramWebSettings, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 5) {
      a.a(paramWebSettings, paramBoolean);
    }
  }
  
  public static void b(WebSettings paramWebSettings, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 5) {
      a.b(paramWebSettings, paramBoolean);
    }
  }
  
  public static void c(WebSettings paramWebSettings, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 7) {
      b.a(paramWebSettings, paramBoolean);
    }
  }
  
  public static void d(WebSettings paramWebSettings, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 7) {
      b.b(paramWebSettings, paramBoolean);
    }
  }
  


  @TargetApi(5)
  private static class a
  {
    static void a(WebSettings paramWebSettings, boolean paramBoolean)
    {
      paramWebSettings.setDatabaseEnabled(paramBoolean);
    }
    
    static void b(WebSettings paramWebSettings, boolean paramBoolean) { paramWebSettings.setGeolocationEnabled(paramBoolean); }
  }
  



  @TargetApi(7)
  private static class b
  {
    static void a(WebSettings paramWebSettings, boolean paramBoolean)
    {
      paramWebSettings.setAppCacheEnabled(paramBoolean);
    }
    
    static void b(WebSettings paramWebSettings, boolean paramBoolean) { paramWebSettings.setDomStorageEnabled(paramBoolean); }
  }
}
