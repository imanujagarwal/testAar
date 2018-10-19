package me.kiip.internal.g;

import android.location.Location;
import android.location.LocationManager;
import java.util.List;








public class f
{
  public static Location a(LocationManager paramLocationManager, float paramFloat)
  {
    List localList = paramLocationManager.getAllProviders();
    Object localObject = null;
    float f1 = Float.MAX_VALUE;
    long l1 = 0L;
    
    if (localList != null) {
      for (String str : localList) {
        Location localLocation = paramLocationManager.getLastKnownLocation(str);
        if (localLocation != null) {
          float f2 = localLocation.getAccuracy();
          long l2 = localLocation.getTime();
          
          if (((float)l2 > paramFloat) && (f2 < f1)) {
            localObject = localLocation;
            f1 = f2;
            l1 = l2;
          }
          else if (((float)l2 < paramFloat) && (f1 == Float.MAX_VALUE) && (l2 > l1)) {
            localObject = localLocation;
            l1 = l2;
          }
        }
      }
    }
    
    return localObject;
  }
}
