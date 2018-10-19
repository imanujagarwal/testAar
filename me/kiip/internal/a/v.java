package me.kiip.internal.a;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;























public class v
{
  public static String a = "Volley";
  
  public static boolean b = Log.isLoggable(a, 2);
  







  public v() {}
  






  public static void a(String paramString, Object... paramVarArgs)
  {
    if (b) {
      Log.v(a, e(paramString, paramVarArgs));
    }
  }
  
  public static void b(String paramString, Object... paramVarArgs) {
    Log.d(a, e(paramString, paramVarArgs));
  }
  
  public static void c(String paramString, Object... paramVarArgs) {
    Log.e(a, e(paramString, paramVarArgs));
  }
  
  public static void a(Throwable paramThrowable, String paramString, Object... paramVarArgs) {
    Log.e(a, e(paramString, paramVarArgs), paramThrowable);
  }
  
  public static void d(String paramString, Object... paramVarArgs) {
    Log.wtf(a, e(paramString, paramVarArgs));
  }
  







  private static String e(String paramString, Object... paramVarArgs)
  {
    String str1 = paramVarArgs == null ? paramString : String.format(Locale.US, paramString, paramVarArgs);
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().fillInStackTrace().getStackTrace();
    
    String str2 = "<unknown>";
    

    for (int i = 2; i < arrayOfStackTraceElement.length; i++) {
      Class localClass = arrayOfStackTraceElement[i].getClass();
      if (!localClass.equals(v.class)) {
        String str3 = arrayOfStackTraceElement[i].getClassName();
        str3 = str3.substring(str3.lastIndexOf('.') + 1);
        str3 = str3.substring(str3.lastIndexOf('$') + 1);
        
        str2 = str3 + "." + arrayOfStackTraceElement[i].getMethodName();
        break;
      }
    }
    return String.format(Locale.US, "[%d] %s: %s", new Object[] {
      Long.valueOf(Thread.currentThread().getId()), str2, str1 });
  }
  


  static class a
  {
    public static final boolean a = v.b;
    a() {}
    
    private static class a
    {
      public final String a;
      public final long b;
      public final long c;
      
      public a(String paramString, long paramLong1, long paramLong2)
      {
        a = paramString;
        b = paramLong1;
        c = paramLong2;
      }
    }
    
    private final List<a> b = new ArrayList();
    private boolean c = false;
    
    public synchronized void a(String paramString, long paramLong)
    {
      if (c) {
        throw new IllegalStateException("Marker added to finished log");
      }
      
      b.add(new a(paramString, paramLong, SystemClock.elapsedRealtime()));
    }
    




    public synchronized void a(String paramString)
    {
      c = true;
      
      long l1 = a();
      if (l1 <= 0L) {
        return;
      }
      
      long l2 = b.get(0)).c;
      v.b("(%-4d ms) %s", new Object[] { Long.valueOf(l1), paramString });
      for (a localA : b) {
        long l3 = c;
        v.b("(+%-4d) [%2d] %s", new Object[] { Long.valueOf(l3 - l2), Long.valueOf(b), a });
        l2 = l3;
      }
    }
    

    protected void finalize()
      throws Throwable
    {
      if (!c) {
        a("Request on the loose");
        v.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
      }
    }
    
    private long a()
    {
      if (b.size() == 0) {
        return 0L;
      }
      
      long l1 = b.get(0)).c;
      long l2 = b.get(b.size() - 1)).c;
      return l2 - l1;
    }
  }
}
