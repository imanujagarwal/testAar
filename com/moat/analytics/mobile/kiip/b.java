package com.moat.analytics.mobile.kiip;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;








final class b
{
  WebView ˏ;
  f ˋ;
  private final int ˎ;
  private boolean ॱ;
  final String ˊ;
  
  static enum a
  {
    static { new int[] { 1 }[1] = 2; }
    public static final int ˎ = 2; public static final int ˏ = 1;
  }
  




































  @SuppressLint({"SetJavaScriptEnabled"})
  b(Application paramApplication, int paramInt)
  {
    ˎ = paramInt;
    ॱ = false;
    
    ˊ = String.format(Locale.ROOT, "_moatTracker%d", new Object[] { Integer.valueOf((int)(Math.random() * 1.0E8D)) });
    

    ˏ = new WebView(paramApplication);
    (
      paramApplication = ˏ.getSettings()).setJavaScriptEnabled(true);
    paramApplication.setAllowContentAccess(false);
    paramApplication.setAllowFileAccess(false);
    paramApplication.setDatabaseEnabled(false);
    paramApplication.setDomStorageEnabled(false);
    paramApplication.setGeolocationEnabled(false);
    paramApplication.setJavaScriptCanOpenWindowsAutomatically(false);
    paramApplication.setSaveFormData(false);
    
    if (Build.VERSION.SDK_INT >= 16) {
      paramApplication.setAllowFileAccessFromFileURLs(false);
      paramApplication.setAllowUniversalAccessFromFileURLs(false);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      paramApplication.setMixedContentMode(1);
    }
    

    paramApplication = f.b.ˏ;
    if (paramInt == a.ˎ) {
      paramApplication = f.b.ˋ;
    }
    try {
      ˋ = new f(ˏ, paramApplication); return;
    } catch (o localO) {
      o.ॱ(
        localO;
    }
  }
  



  final void ˋ(String paramString)
  {
    if (ˎ == a.ˏ) {
      ˏ.setWebViewClient(new WebViewClient()
      {
        public final void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString) {
          if (!b.ˎ(b.this))
            try {
              b.ˊ(b.this);
              ˋ.ॱ(); return;
            } catch (Exception localException) {
              o.ॱ(
                localException;
            }
        }
      });
      ˏ.loadData(
      



































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































        "<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n   <meta charset=\"UTF-8\">\n   <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n    <script src=\"https://z.moatads.com/" + paramString + "/moatad.js\" type=\"text/javascript\"></script>\n</body>\n</html>", "text/html", "utf-8");
    }
  }
  
  final void ˎ(String paramString, Map<String, String> paramMap, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    if (ˎ == a.ˎ)
    {
      ˏ.setWebViewClient(new WebViewClient()
      {
        public final void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString) {
          if (!b.ˎ(b.this)) {
            try {
              b.ˊ(b.this);
              ˋ.ॱ();
              ˋ.ॱ(ˊ); return;
            } catch (Exception localException) {
              o.ॱ(
                localException;
            }
          }
        }
      });
      paramMap = new JSONObject(paramMap);
      
      Integer localInteger = paramInteger3;paramInteger3 = paramMap;paramInteger2 = paramInteger2;paramInteger1 = paramInteger1;paramMap = paramString;paramString = ˊ;ˏ.loadData(
      
























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































        String.format(Locale.ROOT, "<html><head></head><body><div id=\"%s\" style=\"width: %dpx; height: %dpx;\"></div><script>(function initMoatTracking(apiname, pcode, ids, duration) {var events = [];window[pcode + '_moatElToTrack'] = document.getElementById('%s');var moatapi = {'dropTime':%d,'adData': {'ids': ids, 'duration': duration, 'url': 'n/a'},'dispatchEvent': function(ev) {if (this.sendEvent) {if (events) { events.push(ev); ev = events; events = false; }this.sendEvent(ev);} else {events.push(ev);}},'dispatchMany': function(evs){for (var i=0, l=evs.length; i<l; i++) {this.dispatchEvent(evs[i]);}}};Object.defineProperty(window, apiname, {'value': moatapi});var s = document.createElement('script');s.src = 'https://z.moatads.com/' + pcode + '/moatvideo.js?' + apiname + '#' + apiname;document.body.appendChild(s);})('%s', '%s', %s, %s);</script></body></html>", new Object[] { "mianahwvc", paramInteger1, paramInteger2, "mianahwvc", 
        




        Long.valueOf(System.currentTimeMillis()), paramString, paramMap, paramInteger3
        

        .toString(), localInteger }), "text/html", null);
    }
  }
  






























































































































































































































































































































































































































  b() {}
  






























































































































































































































































































































































































































  static void ˏ(int paramInt, String paramString1, Object paramObject, String paramString2)
  {
    if (ˋˎ) {
      if (paramObject == null) {
        paramInt = paramString1;Log.println(paramInt, 
        









































          "Moat" + paramInt, String.format("message = %s", new Object[] { paramString2 }));return;
      }
      
      paramInt = paramString1;Log.println(paramInt, 
      














































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































        "Moat" + paramInt, String.format("id = %s, message = %s", new Object[] { Integer.valueOf(paramObject.hashCode()), paramString2 }));
    }
  }
  
































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































  static void ˏ(String paramString1, Object paramObject, String paramString2)
  {
    if (ˋˏ) {
      Log.println(2, 
      































        "Moat" + paramString1, String.format("id = %s, message = %s", new Object[] { paramObject == null ? "null" : Integer.valueOf(paramObject.hashCode()), paramString2 }));
    }
  }
  







































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































  static void ˊ(String paramString1, Object paramObject, String paramString2, Exception paramException)
  {
    if (ˋˎ) {
      Log.e(
      
























        "Moat" + paramString1, String.format("id = %s, message = %s", new Object[] { Integer.valueOf(paramObject.hashCode()), paramString2 }), paramException);
    }
  }
  













































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































  static void ˎ(String paramString1, String paramString2)
  {
    if ((!ˋˎ) && 
      (getInstanceॱ)) {
      int i = 2;
      if (paramString1.equals("[ERROR] ")) {
        i = 6;
      }
      paramString2 = paramString1 + paramString2;
      Log.println(i, "MoatAnalytics", paramString2);
    }
  }
  












  static String ॱ(View paramView)
  {
    if (paramView != null)
    {
      return paramView.getClass().getSimpleName() + "@" + paramView.hashCode();
    }
    return "null";
  }
}
