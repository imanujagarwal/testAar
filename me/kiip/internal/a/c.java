package me.kiip.internal.a;

import android.os.Process;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

























public class c
  extends Thread
{
  private static final boolean a = v.b;
  

  private final BlockingQueue<n<?>> b;
  

  private final BlockingQueue<n<?>> c;
  

  private final b d;
  

  private final q e;
  

  private volatile boolean f = false;
  





  private final a g;
  






  public c(BlockingQueue<n<?>> paramBlockingQueue1, BlockingQueue<n<?>> paramBlockingQueue2, b paramB, q paramQ)
  {
    b = paramBlockingQueue1;
    c = paramBlockingQueue2;
    d = paramB;
    e = paramQ;
    g = new a(this);
  }
  



  public void a()
  {
    f = true;
    interrupt();
  }
  
  public void run()
  {
    if (a) v.a("start new dispatcher", new Object[0]);
    Process.setThreadPriority(10);
    

    d.a();
    try
    {
      for (;;) {
        b();
      }
    } catch (InterruptedException localInterruptedException) {
      if (f) {
        return;
      }
    }
  }
  





  private void b()
    throws InterruptedException
  {
    final n localN = (n)b.take();
    localN.a("cache-queue-take");
    

    if (localN.f()) {
      localN.b("cache-discard-canceled");
      return;
    }
    

    b.a localA = d.a(localN.d());
    if (localA == null) {
      localN.a("cache-miss");
      
      if (!a.a(g, localN)) {
        c.put(localN);
      }
      return;
    }
    

    if (localA.a()) {
      localN.a("cache-hit-expired");
      localN.a(localA);
      if (!a.a(g, localN)) {
        c.put(localN);
      }
      return;
    }
    

    localN.a("cache-hit");
    p localP = localN.a(new k(a, g));
    
    localN.a("cache-hit-parsed");
    
    if (!localA.b())
    {
      e.a(localN, localP);

    }
    else
    {
      localN.a("cache-hit-refresh-needed");
      localN.a(localA);
      
      d = true;
      
      if (!a.a(g, localN))
      {

        e.a(localN, localP, new Runnable()
        {
          public void run() {
            try {
              c.a(c.this).put(localN);
            }
            catch (InterruptedException localInterruptedException) {
              Thread.currentThread().interrupt();
            }
            
          }
          
        });
      } else {
        e.a(localN, localP);
      }
    }
  }
  









  private static class a
    implements n.a
  {
    private final Map<String, List<n<?>>> a = new HashMap();
    private final c b;
    
    a(c paramC)
    {
      b = paramC;
    }
    

    public void a(n<?> paramN, p<?> paramP)
    {
      if ((b == null) || (b.a())) {
        a(paramN);
        return;
      }
      String str = paramN.d();
      List localList;
      synchronized (this) {
        localList = (List)a.remove(str);
      }
      if (localList != null) {
        if (v.b) {
          v.a("Releasing %d waiting requests for cacheKey=%s.", new Object[] {
            Integer.valueOf(localList.size()), str });
        }
        
        for (??? = localList.iterator(); ((Iterator)???).hasNext();) { n localN = (n)((Iterator)???).next();
          c.b(b).a(localN, paramP);
        }
      }
    }
    

    public synchronized void a(n<?> paramN)
    {
      String str = paramN.d();
      List localList = (List)a.remove(str);
      if ((localList != null) && (!localList.isEmpty())) {
        if (v.b) {
          v.a("%d waiting requests for cacheKey=%s; resend to network", new Object[] {
            Integer.valueOf(localList.size()), str });
        }
        n localN = (n)localList.remove(0);
        a.put(str, localList);
        localN.a(this);
        try {
          c.a(b).put(localN);
        } catch (InterruptedException localInterruptedException) {
          v.c("Couldn't add request to queue. %s", new Object[] { localInterruptedException.toString() });
          
          Thread.currentThread().interrupt();
          
          b.a();
        }
      }
    }
    






    private synchronized boolean b(n<?> paramN)
    {
      String str = paramN.d();
      

      if (a.containsKey(str))
      {
        Object localObject = (List)a.get(str);
        if (localObject == null) {
          localObject = new ArrayList();
        }
        paramN.a("waiting-for-response");
        ((List)localObject).add(paramN);
        a.put(str, localObject);
        if (v.b) {
          v.b("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
        }
        return true;
      }
      

      a.put(str, null);
      paramN.a(this);
      if (v.b) {
        v.b("new request, sending to network %s", new Object[] { str });
      }
      return false;
    }
  }
}
