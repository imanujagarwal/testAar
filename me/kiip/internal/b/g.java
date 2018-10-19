package me.kiip.internal.b;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;
import me.kiip.internal.a.b.a;
import me.kiip.internal.a.k;
import me.kiip.internal.a.v;
































public class g
{
  public static b.a a(k paramK)
  {
    long l1 = System.currentTimeMillis();
    
    Map localMap = c;
    
    long l2 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    long l5 = 0L;
    long l6 = 0L;
    long l7 = 0L;
    long l8 = 0L;
    int i = 0;
    int j = 0;
    
    String str1 = null;
    

    String str2 = (String)localMap.get("Date");
    if (str2 != null) {
      l2 = a(str2);
    }
    
    str2 = (String)localMap.get("Cache-Control");
    if (str2 != null) {
      i = 1;
      localObject = str2.split(",");
      for (int k = 0; k < localObject.length; k++) {
        String str3 = localObject[k].trim();
        if ((str3.equals("no-cache")) || (str3.equals("no-store")))
          return null;
        if (str3.startsWith("max-age=")) {
          try {
            l7 = Long.parseLong(str3.substring(8));
          }
          catch (Exception localException1) {}
        } else if (str3.startsWith("stale-while-revalidate=")) {
          try {
            l8 = Long.parseLong(str3.substring(23));
          }
          catch (Exception localException2) {}
        } else if ((str3.equals("must-revalidate")) || (str3.equals("proxy-revalidate"))) {
          j = 1;
        }
      }
    }
    
    str2 = (String)localMap.get("Expires");
    if (str2 != null) {
      l4 = a(str2);
    }
    
    str2 = (String)localMap.get("Last-Modified");
    if (str2 != null) {
      l3 = a(str2);
    }
    
    str1 = (String)localMap.get("ETag");
    


    if (i != 0) {
      l5 = l1 + l7 * 1000L;
      l6 = j != 0 ? l5 : l5 + l8 * 1000L;

    }
    else if ((l2 > 0L) && (l4 >= l2))
    {
      l5 = l1 + (l4 - l2);
      l6 = l5;
    }
    
    Object localObject = new b.a();
    a = b;
    b = str1;
    f = l5;
    e = l6;
    c = l2;
    d = l3;
    g = localMap;
    h = d;
    
    return localObject;
  }
  


  public static long a(String paramString)
  {
    try
    {
      return a().parse(paramString).getTime();
    }
    catch (ParseException localParseException) {
      v.a(localParseException, "Unable to parse dateStr: %s, falling back to 0", new Object[] { paramString }); }
    return 0L;
  }
  

  static String a(long paramLong)
  {
    return a().format(new Date(paramLong));
  }
  
  private static SimpleDateFormat a() {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
    
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat;
  }
  







  public static String a(Map<String, String> paramMap, String paramString)
  {
    String str = (String)paramMap.get("Content-Type");
    if (str != null) {
      String[] arrayOfString1 = str.split(";");
      for (int i = 1; i < arrayOfString1.length; i++) {
        String[] arrayOfString2 = arrayOfString1[i].trim().split("=");
        if ((arrayOfString2.length == 2) && 
          (arrayOfString2[0].equals("charset"))) {
          return arrayOfString2[1];
        }
      }
    }
    

    return paramString;
  }
  












  static Map<String, String> a(List<me.kiip.internal.a.g> paramList)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    
    for (me.kiip.internal.a.g localG : paramList) {
      localTreeMap.put(localG.a(), localG.b());
    }
    return localTreeMap;
  }
  
  static List<me.kiip.internal.a.g> a(Map<String, String> paramMap) {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    for (Map.Entry localEntry : paramMap.entrySet()) {
      localArrayList.add(new me.kiip.internal.a.g((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return localArrayList;
  }
}
