package me.kiip.internal.b;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import me.kiip.internal.a.b.a;
import me.kiip.internal.a.j;
import me.kiip.internal.a.k;
import me.kiip.internal.a.l;
import me.kiip.internal.a.r;
import me.kiip.internal.a.s;
import me.kiip.internal.a.t;
import me.kiip.internal.a.u;
import me.kiip.internal.a.v;


























public class c
  implements me.kiip.internal.a.h
{
  protected static final boolean a = v.b;
  




  @Deprecated
  protected final i b;
  



  private final b d;
  



  protected final d c;
  




  @Deprecated
  public c(i paramI)
  {
    this(paramI, new d(4096));
  }
  






  @Deprecated
  public c(i paramI, d paramD)
  {
    b = paramI;
    d = new a(paramI);
    c = paramD;
  }
  




  public c(b paramB)
  {
    this(paramB, new d(4096));
  }
  



  public c(b paramB, d paramD)
  {
    d = paramB;
    


    b = paramB;
    c = paramD;
  }
  
  public k a(me.kiip.internal.a.n<?> paramN) throws u
  {
    long l1 = SystemClock.elapsedRealtime();
    for (;;) {
      h localH = null;
      byte[] arrayOfByte = null;
      List localList1 = Collections.emptyList();
      int i;
      Object localObject;
      try {
        Map localMap = a(paramN.e());
        localH = d.a(paramN, localMap);
        i = localH.a();
        
        localList1 = localH.b();
        
        if (i == 304) {
          localObject = paramN.e();
          if (localObject == null) {
            return new k(304, null, true, 
              SystemClock.elapsedRealtime() - l1, localList1);
          }
          
          List localList2 = a(localList1, (b.a)localObject);
          return new k(304, a, true, 
            SystemClock.elapsedRealtime() - l1, localList2);
        }
        

        localObject = localH.d();
        if (localObject != null)
        {
          arrayOfByte = a((InputStream)localObject, localH.c());
        }
        else
        {
          arrayOfByte = new byte[0];
        }
        

        long l2 = SystemClock.elapsedRealtime() - l1;
        a(l2, paramN, arrayOfByte, i);
        
        if ((i < 200) || (i > 299)) {
          throw new IOException();
        }
        return new k(i, arrayOfByte, false, 
          SystemClock.elapsedRealtime() - l1, localList1);
      } catch (SocketTimeoutException localSocketTimeoutException) {
        a("socket", paramN, new t());
      } catch (MalformedURLException localMalformedURLException) {
        throw new RuntimeException("Bad URL " + paramN.c(), localMalformedURLException);
      }
      catch (IOException localIOException) {
        if (localH != null) {
          i = localH.a();
        } else
          throw new l(localIOException);
      }
      v.c("Unexpected response code %d for %s", new Object[] { Integer.valueOf(i), paramN.c() });
      
      if (arrayOfByte != null)
      {
        localObject = new k(i, arrayOfByte, false, SystemClock.elapsedRealtime() - l1, localList1);
        if ((i == 401) || (i == 403))
        {
          a("auth", paramN, new me.kiip.internal.a.a((k)localObject));
        } else {
          if ((i >= 400) && (i <= 499))
          {
            throw new me.kiip.internal.a.d((k)localObject); }
          if ((i >= 500) && (i <= 599)) {
            if (paramN.q()) {
              a("server", paramN, new s((k)localObject));
            }
            else {
              throw new s((k)localObject);
            }
          }
          else
            throw new s((k)localObject);
        }
      } else {
        a("network", paramN, new j());
      }
    }
  }
  




  private void a(long paramLong, me.kiip.internal.a.n<?> paramN, byte[] paramArrayOfByte, int paramInt)
  {
    if ((a) || (paramLong > 3000L)) {
      v.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramN, 
        Long.valueOf(paramLong), paramArrayOfByte != null ? 
        Integer.valueOf(paramArrayOfByte.length) : "null", 
        Integer.valueOf(paramInt), Integer.valueOf(paramN.t().b()) });
    }
  }
  




  private static void a(String paramString, me.kiip.internal.a.n<?> paramN, u paramU)
    throws u
  {
    r localR = paramN.t();
    int i = paramN.s();
    try
    {
      localR.a(paramU);
    } catch (u localU) {
      paramN.a(
        String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw localU;
    }
    paramN.a(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
  }
  
  private Map<String, String> a(b.a paramA)
  {
    if (paramA == null) {
      return Collections.emptyMap();
    }
    
    HashMap localHashMap = new HashMap();
    
    if (b != null) {
      localHashMap.put("If-None-Match", b);
    }
    
    if (d > 0L) {
      localHashMap.put("If-Modified-Since", 
        g.a(d));
    }
    
    return localHashMap;
  }
  





  private byte[] a(InputStream paramInputStream, int paramInt)
    throws IOException, s
  {
    n localN = new n(c, paramInt);
    
    byte[] arrayOfByte1 = null;
    try {
      if (paramInputStream == null) {
        throw new s();
      }
      arrayOfByte1 = c.a(1024);
      int i;
      while ((i = paramInputStream.read(arrayOfByte1)) != -1) {
        localN.write(arrayOfByte1, 0, i);
      }
      return localN.toByteArray();
    }
    finally {
      try {
        if (paramInputStream != null) {
          paramInputStream.close();
        }
      }
      catch (IOException localIOException2)
      {
        v.a("Error occurred when closing InputStream", new Object[0]);
      }
      c.a(arrayOfByte1);
      localN.close();
    }
  }
  



























  private static List<me.kiip.internal.a.g> a(List<me.kiip.internal.a.g> paramList, b.a paramA)
  {
    TreeSet localTreeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    
    if (!paramList.isEmpty()) {
      for (localObject1 = paramList.iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (me.kiip.internal.a.g)((Iterator)localObject1).next();
        localTreeSet.add(((me.kiip.internal.a.g)localObject2).a());
      }
    }
    
    Object localObject2;
    
    Object localObject1 = new ArrayList(paramList);
    Object localObject3; if (h != null) {
      if (!h.isEmpty()) {
        for (localObject2 = h.iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (me.kiip.internal.a.g)((Iterator)localObject2).next();
          if (!localTreeSet.contains(((me.kiip.internal.a.g)localObject3).a())) {
            ((List)localObject1).add(localObject3);
          }
          
        }
      }
    }
    else if (!g.isEmpty()) {
      for (localObject2 = g.entrySet().iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (!localTreeSet.contains(((Map.Entry)localObject3).getKey())) {
          ((List)localObject1).add(new me.kiip.internal.a.g((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue()));
        }
      }
    }
    
    return localObject1;
  }
}
