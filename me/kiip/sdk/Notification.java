package me.kiip.sdk;

import android.graphics.Bitmap;
import android.view.View;




public abstract class Notification
{
  private Object a;
  
  public Notification() {}
  
  public Object getTag()
  {
    return a;
  }
  
  public void setTag(Object tag) {
    a = tag;
  }
  
  public abstract boolean isShowing();
  
  public abstract String getTitle();
  
  public abstract void setTitle(String paramString);
  
  public abstract String getMessage();
  
  public abstract void setMessage(String paramString);
  
  public abstract Bitmap getIcon();
  
  public abstract void setIcon(Bitmap paramBitmap);
  
  public abstract int getGravity();
  
  public abstract void setGravity(int paramInt);
  
  public abstract void setContentView(View paramView);
  
  public abstract void setOnShowListener(OnShowListener paramOnShowListener);
  
  public abstract void setOnClickListener(OnClickListener paramOnClickListener);
  
  public abstract void setOnDismissListener(OnDismissListener paramOnDismissListener);
  
  public static abstract interface OnDismissListener
  {
    public abstract void onDismiss(Notification paramNotification);
  }
  
  public static abstract interface OnClickListener
  {
    public abstract void onClick(Notification paramNotification);
  }
  
  public static abstract interface OnShowListener
  {
    public abstract void onShow(Notification paramNotification);
  }
}
