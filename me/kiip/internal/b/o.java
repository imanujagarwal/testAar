package me.kiip.internal.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.io.File;
import me.kiip.internal.a.h;




























public class o
{
  public static me.kiip.internal.a.o a(Context paramContext, b paramB)
  {
    c localC;
    if (paramB == null) {
      if (Build.VERSION.SDK_INT >= 9) {
        localC = new c(new j());

      }
      else
      {

        String str1 = "volley/0";
        try {
          String str2 = paramContext.getPackageName();
          PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(str2, 0);
          str1 = str2 + "/" + versionCode;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
        

        localC = new c(new f(AndroidHttpClient.newInstance(str1)));
      }
    } else {
      localC = new c(paramB);
    }
    
    return a(paramContext, localC);
  }
  

















  private static me.kiip.internal.a.o a(Context paramContext, h paramH)
  {
    File localFile = new File(paramContext.getCacheDir(), "volley");
    me.kiip.internal.a.o localO = new me.kiip.internal.a.o(new e(localFile), paramH);
    localO.a();
    return localO;
  }
  





  public static me.kiip.internal.a.o a(Context paramContext)
  {
    return a(paramContext, (b)null);
  }
}
