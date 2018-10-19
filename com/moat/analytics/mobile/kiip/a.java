package com.moat.analytics.mobile.kiip;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;




















final class a
{
  private static boolean ˋ = false;
  static WeakReference<Activity> ˊ;
  private static Application ˏ;
  private static int ॱ = 0;
  private static boolean ˎ = false;
  

  a() {}
  
  static void ˊ(Application paramApplication)
  {
    ˏ = paramApplication;
    if (!ˋ) {
      ˋ = true;
      ˏ.registerActivityLifecycleCallbacks(new c());
    }
  }
  
  static Application ˎ() {
    return ˏ;
  }
  


  static class c
    implements Application.ActivityLifecycleCallbacks
  {
    c() {}
    


    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      a.ˊ(1);
    }
    
    public final void onActivityStarted(Activity paramActivity)
    {
      try {
        a.ˊ = new WeakReference(paramActivity);
        a.ˊ(2);
        if (!a.ˋ()) {
          ˋ(true);
        }
        a.ˏ(true);
        b.ˏ(3, "ActivityState", this, "Activity started: " + paramActivity.getClass() + "@" + paramActivity.hashCode()); return;
      } catch (Exception localException) {
        o.ॱ(
          localException;
      }
    }
    
    public final void onActivityResumed(Activity paramActivity) {
      try {
        a.ˊ = new WeakReference(paramActivity);
        a.ˊ(3);
        t.ˋ()
          .ˏ();
        b.ˏ(3, "ActivityState", this, "Activity resumed: " + paramActivity.getClass() + "@" + paramActivity.hashCode());
        if (getInstanceˎ)
          e.ˊ(paramActivity);
        return;
      } catch (Exception localException) {
        o.ॱ(
          localException;
      }
    }
    
    public final void onActivityPaused(Activity paramActivity) {
      try {
        a.ˊ(4);
        if (a.ˎ(paramActivity)) {
          a.ˊ = new WeakReference(null);
        }
        b.ˏ(3, "ActivityState", this, "Activity paused: " + paramActivity.getClass() + "@" + paramActivity.hashCode()); return;
      } catch (Exception localException) {
        o.ॱ(
          localException;
      }
    }
    
    public final void onActivityStopped(Activity paramActivity) {
      try {
        if (a.ˏ() != 3) {
          a.ˏ(false);
          ˋ(false);
        }
        a.ˊ(5);
        if (a.ˎ(paramActivity)) {
          a.ˊ = new WeakReference(null);
        }
        b.ˏ(3, "ActivityState", this, "Activity stopped: " + paramActivity.getClass() + "@" + paramActivity.hashCode()); return;
      } catch (Exception localException) {
        o.ॱ(
          localException;
      }
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      try {
        if ((a.ˏ() != 3) && (a.ˏ() != 5)) {
          if (a.ˋ()) {
            ˋ(false);
          }
          a.ˏ(false);
        }
        a.ˊ(6);
        b.ˏ(3, "ActivityState", this, "Activity destroyed: " + paramActivity.getClass() + "@" + paramActivity.hashCode());
        if (a.ˎ(paramActivity))
          a.ˊ = new WeakReference(null);
        return;
      } catch (Exception localException) {
        o.ॱ(
          localException;
      }
    }
    
    private static void ˋ(boolean paramBoolean) { if (paramBoolean) {
        b.ˏ(3, "ActivityState", null, "App became visible");
        if ((ˋˋ == t.c.ॱ) && 
          (!getInstanceˏ)) {
          k.ˎ().ˋ();
        }
      }
      else {
        b.ˏ(3, "ActivityState", null, "App became invisible");
        if ((ˋˋ == t.c.ॱ) && 
          (!getInstanceˏ)) {
          k.ˎ().ˊ();
        }
      }
    }
  }
}
