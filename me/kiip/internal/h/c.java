package me.kiip.internal.h;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Map;
import me.kiip.internal.e.e;
import me.kiip.internal.g.g.a;
import me.kiip.sdk.Kiip.OnContentListener;
import me.kiip.sdk.Modal.VideoListener;
import me.kiip.sdk.Modal.WebViewListener;


public final class c
  extends WebView
  implements GestureDetector.OnDoubleTapListener
{
  private static final boolean b = me.kiip.internal.e.b.a;
  


  private Runnable c = new Runnable()
  {
    public void run() {
      c.a(c.this).b();
    }
  };
  
  private me.kiip.internal.e.g d;
  
  private boolean e;
  
  private boolean f;
  
  private boolean g;
  
  private a h;
  
  private d i;
  
  private b j;
  
  private c k;
  private GestureDetector l;
  private Kiip.OnContentListener m;
  private Modal.VideoListener n;
  private Modal.WebViewListener o;
  private ArrayList<String> p;
  private VideoView q;
  private ImageButton r;
  private a s;
  static Camera a = null;
  

  private WebViewClient t = new WebViewClient()
  {
    public void onPageStarted(WebView view, String url, Bitmap favicon)
    {
      super.onPageStarted(view, url, favicon);
      if (me.kiip.internal.e.b.a) Log.d("KiipWebView", "onPageStarted url=" + url);
    }
    
    public void onPageFinished(WebView view, String url)
    {
      super.onPageFinished(view, url);
      if (me.kiip.internal.e.b.a) Log.d("KiipWebView", "onPageFinished view=" + view + " url=" + url);
      if ((c.b(c.this) == null) && (!c.c(c.this))) {
        c.a(c.this, true);
        
        if (!c.d(c.this))
        {
          postDelayed(c.e(c.this), 10000L);
        }
        c.b(c.this, false);
      }
    }
    

    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
    {
      super.onReceivedError(view, errorCode, description, failingUrl);
      if (me.kiip.internal.e.b.a) Log.d("KiipWebView", "onReceivedError view=" + view + " errorCode=" + errorCode + " description=" + description + " failingUrl=" + failingUrl);
      c.a(c.this, new me.kiip.internal.e.g(errorCode, description, failingUrl));
      c.f(c.this).a(c.b(c.this));
    }
    
    public boolean shouldOverrideUrlLoading(final WebView view, String url)
    {
      view.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View view, MotionEvent motionEvent) {
          return c.g(c.this).onTouchEvent(motionEvent);
        }
      });
      try {
        Uri localUri = Uri.parse(url);
        if ("kiip".equals(localUri.getScheme())) {
          if (me.kiip.internal.e.b.a) { Log.d("KiipWebView", "JS API: " + localUri + localUri + " Content signatures= " + c.h(c.this));
          }
          
          if (("ready".equals(localUri.getHost())) && 
            (!c.d(c.this))) {
            c.a(c.this).a();
            removeCallbacks(c.e(c.this));
            c.b(c.this, true);
          }
          

          if ("open_camera".equals(localUri.getHost())) {
            c.i(c.this);
          }
          
          if ("close_camera".equals(localUri.getHost())) {
            c.j(c.this);
          }
          String str1;
          Object localObject;
          if ("share".equals(localUri.getHost())) {
            str1 = null;
            localObject = null;
            try {
              str1 = URLDecoder.decode(localUri.getQueryParameter("subject"), "UTF-8");
              localObject = URLDecoder.decode(localUri.getQueryParameter("text"), "UTF-8");
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
            

            if ((str1 != null) || (localObject != null)) {
              localUnsupportedEncodingException = new Intent("android.intent.action.SEND");
              localUnsupportedEncodingException.setFlags(524288);
              localUnsupportedEncodingException.setType("text/plain");
              localUnsupportedEncodingException.putExtra("android.intent.extra.SUBJECT", str1);
              localUnsupportedEncodingException.putExtra("android.intent.extra.TEXT", (String)localObject);
              getContext().startActivity(Intent.createChooser(localUnsupportedEncodingException, "Share via"));
            }
          }
          


          if ("content".equals(localUri.getHost()))
          {

            str1 = localUri.getQueryParameter("content");
            int i;
            try { i = Integer.parseInt(localUri.getQueryParameter("quantity"));
            } catch (NumberFormatException localNumberFormatException) {
              i = -1;
            }
            localObject = localUri.getQueryParameter("transaction_id");
            localUnsupportedEncodingException = localUri.getQueryParameter("signature");
            if ((str1 != null) && (i > 0) && (localObject != null) && (localUnsupportedEncodingException != null) && 
              (c.k(c.this) != null) && (!c.h(c.this).contains(localUnsupportedEncodingException))) {
              c.k(c.this).onContent(str1, i, (String)localObject, localUnsupportedEncodingException);
              c.h(c.this).add(localUnsupportedEncodingException);
            }
          }
          


          if ("video".equals(localUri.getHost()))
          {

            str1 = localUri.getQueryParameter("url");
            localObject = Uri.parse(str1);
            c.l(c.this).setVideoURI((Uri)localObject);
            

            localUnsupportedEncodingException = (RelativeLayout)view.getParent();
            

            final ProgressBar localProgressBar = new ProgressBar(getContext(), null, 16842874);
            localProgressBar.setIndeterminate(true);
            localNumberFormatException = new RelativeLayout.LayoutParams(-2, -2);
            localNumberFormatException.addRule(13);
            localUnsupportedEncodingException.addView(localProgressBar, localNumberFormatException);
            

            c.m(c.this).setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View v) {
                int i = c.l(c.this).getCurrentPosition() / 1000;
                int j = c.l(c.this).getDuration() / 1000;
                
                String str = "javascript:window.location.hash=\"#current_time=" + i + "," + j + "\";";
                c.l(c.this).setVisibility(8);
                c.m(c.this).setVisibility(8);
                view.setVisibility(0);
                localUnsupportedEncodingException.setBackgroundColor(0);
                

                if (Build.VERSION.SDK_INT < 19) {
                  view.loadUrl(str);
                } else {
                  view.evaluateJavascript(str, null);
                }
                

                if (c.n(c.this) != null) {
                  c.n(c.this).onVideoStopped();
                }
                
              }
              
            });
            c.l(c.this).setOnCompletionListener(new MediaPlayer.OnCompletionListener()
            {
              public void onCompletion(MediaPlayer mp) {
                int i = c.l(c.this).getDuration() / 1000;
                c.l(c.this).setVisibility(8);
                c.m(c.this).setVisibility(8);
                view.setVisibility(0);
                localUnsupportedEncodingException.setBackgroundColor(0);
                

                String str = "javascript:window.location.hash=\"#current_time=" + i + "," + i + "\";";
                if (Build.VERSION.SDK_INT < 19) {
                  view.loadUrl(str);
                } else {
                  view.evaluateJavascript(str, null);
                }
                

                if (c.n(c.this) != null) {
                  c.n(c.this).onVideoFinished();
                }
                
              }
            });
            c.l(c.this).setVisibility(0);
            view.setVisibility(4);
            c.l(c.this).requestFocus();
            localProgressBar.setVisibility(0);
            
            c.l(c.this).start();
            
            c.l(c.this).setOnPreparedListener(new MediaPlayer.OnPreparedListener()
            {
              public void onPrepared(MediaPlayer mp) {
                localProgressBar.setVisibility(8);
                

                if (c.n(c.this) != null) {
                  c.n(c.this).onVideoWillPlay();
                }
                localUnsupportedEncodingException.setBackgroundColor(-16777216);
                c.m(c.this).setVisibility(0);
                c.l(c.this).start();
              }
            });
          }
          

          if ("did_dismiss".equals(localUri.getHost()))
          {
            if (localUri.getQueryParameter("close") == null) {
              c.a(c.this).a(true);
            } else {
              c.a(c.this).a(false);
            }
            
            if (me.kiip.internal.e.b.a) { Log.d("KiipWebView", "uri =" + localUri);
            }
            


            str1 = localUri.getQueryParameter("content");
            int j;
            try { j = Integer.parseInt(localUri.getQueryParameter("quantity"));
            } catch (NumberFormatException localNumberFormatException1) {
              j = -1;
            }
            localObject = localUri.getQueryParameter("transaction_id");
            localUnsupportedEncodingException = localUri.getQueryParameter("signature");
            if ((str1 != null) && (j > 0) && (localObject != null) && (localUnsupportedEncodingException != null) && (c.k(c.this) != null)) {
              c.k(c.this).onContent(str1, j, (String)localObject, localUnsupportedEncodingException);
            }
            


            localNumberFormatException1 = localUri.getQueryParameter("url");
            String str2 = localUri.getQueryParameter("delay");
            if (localNumberFormatException1 == null) localNumberFormatException1 = localUri.getQueryParameter("native_url");
            if (localNumberFormatException1 != null) {
              try {
                c.o(c.this).a(true);
                
                if ((localNumberFormatException1.startsWith("http")) || (localNumberFormatException1.startsWith("https")) || (localNumberFormatException1.startsWith("www"))) {
                  if (str2 != null) {
                    d.a(getContext(), localNumberFormatException1, str2, c.p(c.this));
                  } else {
                    d.a(getContext(), localNumberFormatException1, c.p(c.this));
                  }
                } else {
                  getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(localNumberFormatException1)));
                }
              }
              catch (Exception localException)
              {
                return false;
              }
            }
            
            if (c.q(c.this) != null) {
              c.q(c.this).b();
              e.a(null);
            }
            
            c.j(c.this);
          }
          
          return true; }
        if ((!"api.kiip.me".equals(localUri.getScheme())) && 
          (c.r(c.this)) && (c.c(c.this))) {
          try {
            d.a(getContext(), url, c.p(c.this));
          } catch (Exception localException2) {
            return false;
          }
          return true;
        }
      }
      catch (NullPointerException localNullPointerException1) {}
      


      return false;
    }
  };
  
  private int a() {
    int i1 = 0;
    for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(i2, localCameraInfo);
      if (facing == 0) {
        i1 = i2;
        break;
      }
    }
    return i1;
  }
  
  private void b() {
    try {
      s.a();
      
      if (a != null) {
        a.stopPreview();
        a.release();
        a = null;
      }
      
      if ((a == null) && (Build.VERSION.SDK_INT >= 9)) {
        Boolean localBoolean = Boolean.valueOf(false);
        try
        {
          a = Camera.open(a());
          s.setCamera(a);
          e();
          localBoolean = Boolean.valueOf(true);
        } catch (Exception localException2) {
          if (me.kiip.internal.e.b.a) localException2.printStackTrace();
        } finally {
          if ((!localBoolean.booleanValue()) && (a != null)) {
            a.stopPreview();
            a.release();
            a = null;
          }
        }
      }
    }
    catch (Exception localException1) {
      Log.e("KiipWebView", localException1.getMessage());
    }
  }
  
  private void c() {
    if (a != null) {
      s.b();
      a.stopPreview();
      a.release();
      a = null;
    }
  }
  
  private static Activity a(Context paramContext) {
    if (paramContext == null)
      return null;
    if ((paramContext instanceof Activity))
      return (Activity)paramContext;
    if ((paramContext instanceof ContextWrapper)) {
      return a(((ContextWrapper)paramContext).getBaseContext());
    }
    return null;
  }
  
  private void a(String paramString) {
    c localC = this;
    String str = String.format("window.location='#%s'", new Object[] { paramString });
    if (Build.VERSION.SDK_INT < 19) {
      localC.loadUrl(str);
    } else {
      localC.evaluateJavascript(str, null);
    }
    if (me.kiip.internal.e.b.a) Log.d("KiipWebView", str);
  }
  
  private void d()
  {
    if (ContextCompat.checkSelfPermission(getContext(), "android.permission.CAMERA") != 0) {
      e.a(new Handler() {
        public void handleMessage(Message msg) {
          switch (what) {
          case 0: 
            if (c.q(c.this) != null) {
              c.q(c.this).a();
            }
            c.a(c.this, "camera=off");
            break;
          
          case 1: 
            if (c.q(c.this) != null) {
              c.q(c.this).b();
            }
            c.a(c.this, "camera=on");
            c.s(c.this);
          }
          
          
          if (me.kiip.internal.e.b.a) Log.d("KiipWebView", msg.toString());
        }
      });
      ActivityCompat.requestPermissions(a(getContext()), new String[] { "android.permission.CAMERA" }, 5001);
    }
    else
    {
      a("camera=on");
      b();
    }
  }
  
  public c(Context paramContext, VideoView paramVideoView, ImageButton paramImageButton) {
    super(paramContext);
    a(paramVideoView, null, paramImageButton);
  }
  
  public c(Context paramContext, VideoView paramVideoView, a paramA, ImageButton paramImageButton) {
    super(paramContext);
    a(paramVideoView, paramA, paramImageButton);
  }
  
  private void e() {
    final c localC = this;
    me.kiip.internal.g.g localG = me.kiip.internal.g.g.a(getContext());
    localG.a(new g.a()
    {
      public void a(double paramAnonymousDouble1, double paramAnonymousDouble2) {
        String str1 = String.format("{\"gravityData\": {\"z\": %.6f},\"headingData\": {\"trueHeading\": %.3f} }", new Object[] { Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2) });
        if (me.kiip.internal.e.b.a) Log.d("KiipWebView", str1);
        final String str2 = String.format("window.kiipSDKMessage('%s')", new Object[] { str1 });
        localC.post(new Runnable()
        {
          public void run() {
            if (Build.VERSION.SDK_INT < 19) {
              a.loadUrl(str2);
            } else {
              a.evaluateJavascript(str2, null);
            }
          }
        });
      }
    });
    localG.b();
  }
  



  @SuppressLint({"SetJavaScriptEnabled"})
  private void a(VideoView paramVideoView, a paramA, ImageButton paramImageButton)
  {
    WebSettings localWebSettings = getSettings();
    

    int i1 = Build.VERSION.SDK_INT;
    if (i1 > 16) {
      localWebSettings.setMediaPlaybackRequiresUserGesture(false);
    }
    


    if ((me.kiip.internal.e.b.a) && 
      (i1 >= 19)) {
      WebView.setWebContentsDebuggingEnabled(true);
    }
    

    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(1);
    me.kiip.internal.l.b.c(localWebSettings, true);
    
    me.kiip.internal.l.b.a(localWebSettings, true);
    me.kiip.internal.l.b.d(localWebSettings, true);
    me.kiip.internal.l.b.b(localWebSettings, true);
    

    if (Build.VERSION.SDK_INT <= 15) {
      me.kiip.internal.l.c.a(this, 1, null);
    }
    setBackgroundColor(0);
    setScrollBarStyle(0);
    

    me.kiip.internal.k.a localA = new me.kiip.internal.k.a();
    localA.a("");
    setWebChromeClient(localA);
    

    setWebViewClient(t);
    
    q = paramVideoView;
    r = paramImageButton;
    s = paramA;
    

    p = new ArrayList();
    
    l = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener());
    l.setOnDoubleTapListener(this);
  }
  
  public void setOnShowURLListener(b listener) {
    j = listener;
  }
  
  public void setOnJSListener(a listener) {
    h = listener;
  }
  
  public void setOnViewObjectListener(c listener) {
    k = listener;
  }
  
  public void setOnWebViewErrorListener(d listener) {
    i = listener;
  }
  
  public void setOnContentListener(Kiip.OnContentListener listener) {
    m = listener;
  }
  
  public void setVideoListener(Modal.VideoListener listener) {
    n = listener;
  }
  
  public Modal.VideoListener getVideoListener() {
    return n;
  }
  
  public void setWebViewListener(Modal.WebViewListener listener) {
    o = listener;
  }
  

  public void loadUrl(String url)
  {
    super.loadUrl(url, null);
  }
  
  public void loadUrl(String url, Map<String, String> additionalHttpHeaders)
  {
    d = null;
    e = false;
    f = false;
    g = false;
    super.loadUrl(url, additionalHttpHeaders);
  }
  
  public void stopLoading()
  {
    removeCallbacks(c);
    
    super.stopLoading();
  }
  
  public boolean onTouchEvent(MotionEvent event)
  {
    if (f) {
      if (event.getAction() == 0) {
        g = false;
      } else if (event.getAction() == 1) {
        g = true;
      }
    }
    return super.onTouchEvent(event);
  }
  

  public boolean onSingleTapConfirmed(MotionEvent motionEvent)
  {
    return false;
  }
  
  public boolean onDoubleTap(MotionEvent motionEvent)
  {
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent motionEvent)
  {
    return true;
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void a(me.kiip.internal.e.g paramG);
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void a(boolean paramBoolean);
  }
}
