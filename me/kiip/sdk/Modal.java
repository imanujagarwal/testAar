package me.kiip.sdk;


public abstract class Modal
{
  private Object a;
  

  public Modal() {}
  
  public Object getTag()
  {
    return a;
  }
  
  public void setTag(Object tag) {
    a = tag;
  }
  
  public abstract boolean isShowing();
  
  public abstract void setOnShowListener(OnShowListener paramOnShowListener);
  
  public abstract void setOnDismissListener(OnDismissListener paramOnDismissListener);
  
  public abstract void setVideoListener(VideoListener paramVideoListener);
  
  public abstract void setWebViewListener(WebViewListener paramWebViewListener);
  
  public static abstract interface WebViewListener
  {
    public abstract void onWebViewOpen();
    
    public abstract void onWebViewDismiss();
  }
  
  public static abstract interface VideoListener
  {
    public abstract void onVideoWillPlay();
    
    public abstract void onVideoStopped();
    
    public abstract void onVideoFinished();
  }
  
  public static abstract interface OnDismissListener
  {
    public abstract void onDismiss(Modal paramModal);
  }
  
  public static abstract interface OnShowListener
  {
    public abstract void onShow(Modal paramModal);
  }
}
