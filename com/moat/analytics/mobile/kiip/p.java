package com.moat.analytics.mobile.kiip;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.support.annotation.FloatRange;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.lang.ref.WeakReference;















final class p
{
  private static String ˋ;
  private static b ॱ = null;
  private static a ˏ = null;
  
  p() {}
  
  @FloatRange(from=0.0D, to=1.0D)
  static double ॱ() {
    try {
      AudioManager localAudioManager = (AudioManager)a.ˎ().getSystemService(ॱ("㇕ꍩ߆嗠殛").intern());
      int j = ʼ();
      int i = localAudioManager.getStreamMaxVolume(3);
      return j / i;
    } catch (Exception localException) {
      o.ॱ(localException; }
    return 0.0D;
  }
  

  private static int ʼ()
  {
    try
    {
      return ((AudioManager)a.ˎ().getSystemService(ॱ("㇕ꍩ߆嗠殛").intern())).getStreamVolume(3);
    } catch (Exception localException) {
      o.ॱ(localException; }
    return 0;
  }
  
  static void ˊ(Application paramApplication)
  {
    try {
      AsyncTask.execute(new Runnable()
      {
        public final void run() {
          try {
            AdvertisingIdClient.Info localInfo;
            if (!(localInfo = AdvertisingIdClient.getAdvertisingIdInfo(ˊ)).isLimitAdTrackingEnabled()) {
              p.ˎ(localInfo.getId());
              b.ˏ(3, "Util", this, "Retrieved Advertising ID = " + p.ʻ());return;
            }
            b.ˏ(3, "Util", this, "User has limited ad tracking"); return;
          }
          catch (Exception localException) {
            o.ॱ(
              localException;
          }
        }
      }); return;
    } catch (Exception localException) { o.ॱ(
        localException;
    }
  }
  
  static String ˏ() { return ˋ; }
  
  static Context ˋ()
  {
    WeakReference localWeakReference;
    if ((localWeakReference = getInstanceˋ) != null) return (Context)localWeakReference.get();
    return null;
  }
  
  static b ˎ() {
    if ((ॱ == null) || (!b.ˎ(ॱ))) {
      ॱ = new b((byte)0);
    }
    return ॱ;
  }
  
  static class b
  {
    private boolean ॱ = false;
    private String ˎ = "_unknown_";
    private String ˋ = "_unknown_";
    private String ˏ = "_unknown_";
    
    private b() {
      try {
        Object localObject;
        if ((localObject = p.ˋ()) != null) {
          ॱ = true;
          PackageManager localPackageManager = ((Context)localObject).getPackageManager();
          ˋ = ((Context)localObject).getPackageName();
          localObject = ((Context)localObject).getApplicationInfo();
          localObject = localPackageManager.getApplicationLabel((ApplicationInfo)localObject);
          ˎ = ((CharSequence)localObject).toString();
          ˏ = localPackageManager.getInstallerPackageName(ˋ);
          return;
        }
        b.ˏ(3, "Util", this, "Can't get app name, appContext is null."); return;
      }
      catch (Exception localException) {
        o.ॱ(
          localException;
      }
    }
    
    final String ˏ() { return ˎ; }
    
    final String ˋ()
    {
      return ˋ;
    }
    
    final String ॱ() {
      if (ˏ != null) return ˏ; return "_unknown_";
    }
  }
  
  static a ˊ()
  {
    if ((ˏ == null) || (!ˏᐝ)) {
      ˏ = new a((byte)0);
    }
    return ˏ;
  }
  
  static class a
  {
    String ˋ = "_unknown_";
    String ˊ = "_unknown_";
    Integer ˎ = Integer.valueOf(-1);
    boolean ˏ = false;
    boolean ॱ = false;
    boolean ᐝ = false;
    
    private a() {
      try {
        Context localContext;
        if ((localContext = p.ˋ()) != null) {
          ᐝ = true;
          TelephonyManager localTelephonyManager = (TelephonyManager)localContext.getSystemService("phone");
          ˋ = localTelephonyManager.getSimOperatorName();
          ˊ = localTelephonyManager.getNetworkOperatorName();
          ˎ = Integer.valueOf(localTelephonyManager.getPhoneType());
          ˏ = p.ˊॱ();
          ॱ = p.ˎ(localContext);
        }
        return;
      } catch (Exception localException) { o.ॱ(
          localException;
      }
    }
  }
  













  static boolean ˎ(Context paramContext)
  {
    return (getApplicationInfoflags & 0x2) != 0;
  }
  





















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































  private static long ˊ = 9141242330850693853L;
  
  /* Error */
  private static String ॱ(String arg0)
  {
    // Byte code:
    //   0: aload 0
    //   2: invokevirtual 61	java/lang/String:toCharArray	()[C
    //   5: checkcast 3	[C
    //   8: dup
    //   9: astore_3
    //   10: iconst_0
    //   11: caload
    //   12: istore_0
    //   13: aload_3
    //   14: arraylength
    //   15: iconst_1
    //   16: isub
    //   17: newarray char
    //   19: astore_1
    //   20: iconst_1
    //   21: istore_2
    //   22: iload_2
    //   23: aload_3
    //   24: arraylength
    //   25: if_icmpge +8 -> 33
    //   28: goto_w 0 0 0 71
    //   33: goto_w 0 0 0 59
    //   38: aload_1
    //   39: iload_2
    //   40: iconst_1
    //   41: isub
    //   42: aload_3
    //   43: iload_2
    //   44: caload
    //   45: iload_2
    //   46: iload_0
    //   47: imul
    //   48: ixor
    //   49: i2l
    //   50: getstatic 36	com/moat/analytics/mobile/kiip/p:ˊ	J
    //   53: lxor
    //   54: l2i
    //   55: i2c
    //   56: castore
    //   57: iinc 2 1
    //   60: goto_w -1 -1 -1 -38
    //   65: new 25	java/lang/String
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 59	java/lang/String:<init>	([C)V
    //   73: areturn
    //   74: lookupswitch	default:+-9->65, 75:+-36->38
    //   92: bipush 11
    //   94: goto_w -1 -1 -1 -20
    //   99: bipush 75
    //   101: goto_w -1 -1 -1 -27
    // Line number table:
    //   Java source line #76	-> byte code offset #0
    //   Java source line #79	-> byte code offset #13
    //   Java source line #80	-> byte code offset #20
    //   Java source line #82	-> byte code offset #38
    //   Java source line #80	-> byte code offset #57
    //   Java source line #86	-> byte code offset #65
  }
}
