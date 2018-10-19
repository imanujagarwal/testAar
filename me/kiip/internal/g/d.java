package me.kiip.internal.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import java.security.MessageDigest;
import java.util.UUID;
import me.kiip.internal.e.b;






















































public class d
{
  public static String a(Context paramContext)
  {
    String str = "";
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("me.kiip.sdk", 0);
    str = localSharedPreferences.getString("kiip_uuid", null);
    if (str == null) {
      str = UUID.randomUUID().toString();
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.putString("kiip_uuid", str).commit();
      if (b.a) { Log.d("DeviceHelper", "KIIP_UUID:" + str);
      }
    }
    return str;
  }
  
  private static SharedPreferences b(Context paramContext) {
    return paramContext.getSharedPreferences("me.kiip.sdk", 0);
  }
  
  public static String a(Context paramContext, String paramString) {
    return b(paramContext).getString(paramString, "");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    b(paramContext).edit().putString(paramString1, paramString2).commit();
  }
  




























  public static String a(String paramString)
  {
    String str = "";
    try {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte1 = paramString.getBytes("UTF-8");
      localMessageDigest.update(arrayOfByte1, 0, arrayOfByte1.length);
      StringBuilder localStringBuilder = new StringBuilder();
      for (byte b : localMessageDigest.digest()) {
        localStringBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(b) }));
      }
      str = localStringBuilder.toString();
    } catch (Exception localException) {
      Log.e("DeviceHelper", localException.getMessage());
    }
    return str;
  }
}
