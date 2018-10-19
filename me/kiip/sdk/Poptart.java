package me.kiip.sdk;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;


public abstract class Poptart
  implements DialogInterface
{
  private Object a;
  
  public Poptart() {}
  
  public Object getTag()
  {
    return a;
  }
  
  public void setTag(Object tag) {
    a = tag;
  }
  
  public abstract boolean isShowing();
  
  public abstract Notification getNotification();
  
  public abstract void setNotification(Notification paramNotification);
  
  public abstract Modal getModal();
  
  public abstract String getTitle();
  
  public abstract String getMessage();
  
  public abstract String getRewardURL();
  
  public abstract void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener);
  
  public abstract void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener);
  
  public abstract void show(Context paramContext);
  
  public abstract void showNativeReward(KiipNativeRewardView paramKiipNativeRewardView);
  
  public abstract void show(Context paramContext, boolean paramBoolean);
  
  public abstract void cancel();
  
  public abstract void dismiss();
}
