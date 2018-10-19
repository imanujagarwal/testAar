package me.kiip.internal.g;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;






public class c
{
  public static String a(ConnectivityManager paramConnectivityManager)
  {
    String str = null;
    
    NetworkInfo localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo != null) {
      switch (localNetworkInfo.getType()) {
      case 1: 
        str = localNetworkInfo.getTypeName();
        break;
      case 0: 
        str = localNetworkInfo.getSubtypeName();
        break;
      default: 
        str = "unknown";
      }
      
    }
    return str;
  }
}
