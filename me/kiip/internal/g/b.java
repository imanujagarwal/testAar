package me.kiip.internal.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;




public class b
{
  public static int a(Context paramContext)
  {
    int i = -1;
    try {
      String str = paramContext.getPackageName();
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(str, 0);
      i = versionCode;
    } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
      localNameNotFoundException.printStackTrace();
    }
    return i;
  }
  
  public static String b(Context paramContext) {
    String str1 = null;
    try {
      String str2 = paramContext.getPackageName();
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(str2, 0);
      str1 = versionName;
    } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
      localNameNotFoundException.printStackTrace();
    }
    return str1;
  }
}
