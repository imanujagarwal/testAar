package me.kiip.internal.k;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class a extends WebChromeClient
{
  final me.kiip.internal.l.a b = new me.kiip.internal.l.a();
  

  public a() {}
  
  public void a(String paramString)
  {
    b.a(paramString);
  }
  
  public boolean onJsAlert(WebView view, String url, String message, JsResult result)
  {
    b.a(view, url, message, result);
    
    return true;
  }
  
  public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result)
  {
    b.b(view, url, message, result);
    
    return true;
  }
  
  public boolean onJsConfirm(WebView view, String url, String message, JsResult result)
  {
    b.c(view, url, message, result);
    
    return true;
  }
  
  public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result)
  {
    b.a(view, url, message, defaultValue, result);
    
    return true;
  }
}
