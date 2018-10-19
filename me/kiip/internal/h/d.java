package me.kiip.internal.h;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import me.kiip.internal.e.c;
import me.kiip.internal.k.a;
import me.kiip.sdk.Modal.WebViewListener;









public class d
  extends c
{
  private static final boolean a = me.kiip.internal.e.b.a;
  
  private LinearLayout b;
  
  private LinearLayout c;
  
  private d d;
  private WebView e;
  private String f;
  private int g;
  private EditText h;
  private ImageButton i;
  private ImageButton j;
  private ImageButton k;
  private ImageButton l;
  private static Modal.WebViewListener m;
  private boolean n = false;
  private Handler o;
  
  private static final class a implements Runnable {
    private final WeakReference<LinearLayout> a;
    
    protected a(LinearLayout paramLinearLayout) { a = new WeakReference(paramLinearLayout); }
    

    public void run()
    {
      LinearLayout localLinearLayout = (LinearLayout)a.get();
      if (localLinearLayout != null) {
        localLinearLayout.setVisibility(0);
      }
    }
  }
  
  public d(Context paramContext, String paramString1, String paramString2) {
    super(paramContext);
    f = paramString2;
    g = (Integer.parseInt(paramString1) * 1000);
    a();
    d = this;
  }
  
  public d(Context paramContext, String paramString) {
    super(paramContext);
    f = paramString;
    a();
    d = this;
  }
  

  private void a()
  {
    Context localContext = getContext();
    
    getWindow().setBackgroundDrawableResource(17170447);
    
    b = new LinearLayout(localContext);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
    b.setLayoutParams(localLayoutParams1);
    b.setOrientation(1);
    
    RelativeLayout localRelativeLayout = new RelativeLayout(localContext);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
    localRelativeLayout.setLayoutParams(localLayoutParams2);
    

    h = new EditText(localContext);
    h.setId(2);
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams3.addRule(10);
    h.setLayoutParams(localLayoutParams3);
    h.setFocusable(false);
    h.setSingleLine();
    h.setPadding(20, 20, 20, 20);
    h.setBackgroundColor(Color.parseColor("#000000"));
    h.setTextColor(Color.parseColor("#ffffff"));
    h.setTextSize(2, 22.0F);
    localRelativeLayout.addView(h);
    
    c = new LinearLayout(localContext);
    c.setId(1);
    RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams4.addRule(12);
    c.setLayoutParams(localLayoutParams4);
    c.setBackgroundColor(Color.parseColor("#000000"));
    localRelativeLayout.addView(c);
    
    i = a(b.a.a(localContext));
    j = a(b.b.a(localContext));
    k = a(b.c.a(localContext));
    l = a(b.d.a(localContext));
    
    c.addView(i);
    c.addView(j);
    c.addView(k);
    c.addView(l);
    c.setVisibility(8);
    

    e = new WebView(localContext);
    RelativeLayout.LayoutParams localLayoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams5.addRule(2, 1);
    localLayoutParams5.addRule(3, 2);
    e.setLayoutParams(localLayoutParams5);
    localRelativeLayout.addView(e);
    
    b.addView(localRelativeLayout);
  }
  
  private ImageButton a(Drawable paramDrawable)
  {
    ImageButton localImageButton = new ImageButton(getContext());
    
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0F);
    gravity = 16;
    localImageButton.setLayoutParams(localLayoutParams);
    localImageButton.setColorFilter(Color.parseColor("#ffffff"));
    localImageButton.setBackgroundColor(Color.parseColor("#000000"));
    localImageButton.setImageDrawable(paramDrawable);
    
    return localImageButton;
  }
  








  private void b()
  {
    WebSettings localWebSettings = e.getSettings();
    
    localWebSettings.setJavaScriptEnabled(true);
    





    localWebSettings.setSupportZoom(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setCacheMode(-1);
    
    if (f == null) {
      f = "http://kiip.me";
    }
    
    e.loadUrl(f);
    

    e.setWebChromeClient(new a() {
      public void onProgressChanged(WebView webView, int progress) {
        d.a(d.this).setText("Loading...");
        if (progress == 100) {
          d.a(d.this).setText(webView.getUrl());
        }
        
      }
    });
    e.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView view, String url)
      {
        new Timer().schedule(new TimerTask()
        {
          public void run() {
            d.a(d.this, true);
            if (me.kiip.internal.e.b.a) Log.d("KiipWebView", "enabling back button"); } }, 2000L);
      }
      

      public boolean shouldOverrideUrlLoading(WebView view, String url)
      {
        if ((url.startsWith("http")) || (url.startsWith("https")) || (url.startsWith("www")))
          return false;
        if (Uri.parse(url).getScheme().equals("market"))
          try {
            getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
            d.b(d.this).dismiss();
            return true;
          } catch (ActivityNotFoundException localActivityNotFoundException) {
            Uri localUri = Uri.parse(url);
            view.loadUrl("http://play.google.com/store/apps/" + localUri.getHost() + "?" + localUri.getQuery());
            return false;
          }
        if (Uri.parse(url).getScheme().equals("intent")) {
          try {
            localActivityNotFoundException = Uri.parse(url).getQueryParameter("link");
            getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(localActivityNotFoundException)));
            d.b(d.this).dismiss();
            return true;
          } catch (ActivityNotFoundException localActivityNotFoundException1) {
            return false;
          }
        }
        try
        {
          getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
          d.b(d.this).hide();
          return true;
        }
        catch (ActivityNotFoundException localActivityNotFoundException2) {
          Log.d("KiipWebView", localActivityNotFoundException2.toString()); }
        return false;
      }
    });
  }
  


  public void show()
  {
    super.show();
    if (m != null) {
      m.onWebViewOpen();
    }
    if (me.kiip.internal.e.b.a) Log.d("KiipWebView", "onShow");
  }
  
  public void cancel()
  {
    try {
      e.stopLoading();
    }
    catch (NullPointerException localNullPointerException) {}
    
    if (m != null) {
      m.onWebViewDismiss();
    }
    
    ViewGroup localViewGroup = (ViewGroup)e.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(e);
    }
    e.destroy();
    if (o != null) {
      o.removeCallbacksAndMessages(null);
    }
    super.cancel();
    if (me.kiip.internal.e.b.a) Log.d("KiipWebView", "onCancel");
  }
  
  public void dismiss()
  {
    try {
      e.stopLoading();
    }
    catch (NullPointerException localNullPointerException) {}
    
    if (m != null) {
      m.onWebViewDismiss();
    }
    
    ViewGroup localViewGroup = (ViewGroup)e.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(e);
    }
    e.destroy();
    if (o != null) {
      o.removeCallbacksAndMessages(null);
    }
    super.dismiss();
    if (me.kiip.internal.e.b.a) { Log.d("KiipWebView", "onDismiss");
    }
  }
  
  public void onBackPressed()
  {
    if (n) {
      dismiss();
    }
    if (me.kiip.internal.e.b.a) Log.d("KiipWebView", "onBackPressed");
  }
  
  private void c() {
    i.setBackgroundColor(0);
    i.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        if (d.c(d.this).canGoBack()) {
          d.c(d.this).goBack();
        }
        
      }
    });
    j.setBackgroundColor(0);
    j.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        if (d.c(d.this).canGoForward()) {
          d.c(d.this).goForward();
        }
        
      }
    });
    k.setBackgroundColor(0);
    k.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        d.c(d.this).reload();
      }
      
    });
    l.setBackgroundColor(0);
    l.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View v) {
        dismiss();
      }
    });
  }
  
  private void d() {
    CookieSyncManager.createInstance(getContext());
    CookieSyncManager.getInstance().startSync();
  }
  
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    
    getWindow().requestFeature(2);
    getWindow().setFeatureInt(2, -1);
    
    setContentView(b);
    b();
    c();
    d();
    
    if (g != 0) {
      o = new Handler();
      o.postDelayed(new a(c), g);
    } else {
      c.setVisibility(0);
    }
  }
  
  public static void a(Context paramContext, String paramString, Modal.WebViewListener paramWebViewListener) {
    d localD = new d(paramContext, paramString);
    a(paramWebViewListener);
    localD.show();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Modal.WebViewListener paramWebViewListener) {
    d localD = new d(paramContext, paramString2, paramString1);
    a(paramWebViewListener);
    localD.show();
  }
  
  private static void a(Modal.WebViewListener paramWebViewListener) {
    m = paramWebViewListener;
  }
}
