package me.kiip.internal.a;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
































public class o
{
  private final AtomicInteger a = new AtomicInteger();
  





  private final Set<n<?>> b = new HashSet();
  

  private final PriorityBlockingQueue<n<?>> c = new PriorityBlockingQueue();
  


  private final PriorityBlockingQueue<n<?>> d = new PriorityBlockingQueue();
  


  private final b e;
  


  private final h f;
  


  private final q g;
  

  private final i[] h;
  

  private c i;
  

  private final List<a> j = new ArrayList();
  









  public o(b paramB, h paramH, int paramInt, q paramQ)
  {
    e = paramB;
    f = paramH;
    h = new i[paramInt];
    g = paramQ;
  }
  






  public o(b paramB, h paramH, int paramInt)
  {
    this(paramB, paramH, paramInt, new f(new Handler(
      Looper.getMainLooper())));
  }
  





  public o(b paramB, h paramH)
  {
    this(paramB, paramH, 4);
  }
  


  public void a()
  {
    b();
    
    i = new c(c, d, e, g);
    i.start();
    

    for (int k = 0; k < h.length; k++) {
      i localI = new i(d, f, e, g);
      
      h[k] = localI;
      localI.start();
    }
  }
  


  public void b()
  {
    if (i != null) {
      i.a();
    }
    for (i localI : h) {
      if (localI != null) {
        localI.a();
      }
    }
  }
  


  public int c()
  {
    return a.incrementAndGet();
  }
  


  public b d()
  {
    return e;
  }
  











































  public <T> n<T> a(n<T> paramN)
  {
    paramN.a(this);
    synchronized (b) {
      b.add(paramN);
    }
    

    paramN.a(c());
    paramN.a("add-to-queue");
    

    if (!paramN.p()) {
      d.add(paramN);
      return paramN;
    }
    c.add(paramN);
    return paramN;
  }
  




  <T> void b(n<T> paramN)
  {
    synchronized (b) {
      b.remove(paramN);
    }
    synchronized (j) {
      for (a localA : j) {
        localA.a(paramN);
      }
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(n<T> paramN);
  }
}
