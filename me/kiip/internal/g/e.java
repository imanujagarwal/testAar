package me.kiip.internal.g;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;








public class e
{
  public static void a(Context paramContext, DisplayMetrics paramDisplayMetrics)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    localDisplay.getMetrics(paramDisplayMetrics);
    try {
      Method localMethod1 = Display.class.getMethod("getRawWidth", new Class[0]);
      Method localMethod2 = Display.class.getMethod("getRawHeight", new Class[0]);
      
      widthPixels = ((Integer)localMethod1.invoke(localDisplay, new Object[0])).intValue();
      heightPixels = ((Integer)localMethod2.invoke(localDisplay, new Object[0])).intValue();
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalAccessException localIllegalAccessException) {}catch (InvocationTargetException localInvocationTargetException) {}
  }
}
