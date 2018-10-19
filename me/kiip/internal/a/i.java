package me.kiip.internal.a;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;






























public class i
  extends Thread
{
  private final BlockingQueue<n<?>> a;
  private final h b;
  private final b c;
  private final q d;
  private volatile boolean e = false;
  









  public i(BlockingQueue<n<?>> paramBlockingQueue, h paramH, b paramB, q paramQ)
  {
    a = paramBlockingQueue;
    b = paramH;
    c = paramB;
    d = paramQ;
  }
  



  public void a()
  {
    e = true;
    interrupt();
  }
  
  @TargetApi(14)
  private void a(n<?> paramN)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      TrafficStats.setThreadStatsTag(paramN.b());
    }
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    try {
      for (;;) {
        b();
      }
    } catch (InterruptedException localInterruptedException) {
      if (e) {
        return;
      }
    }
  }
  



  private void b()
    throws InterruptedException
  {
    long l = SystemClock.elapsedRealtime();
    
    n localN = (n)a.take();
    try
    {
      localN.a("network-queue-take");
      


      if (localN.f()) {
        localN.b("network-discard-cancelled");
        localN.w();
        return;
      }
      
      a(localN);
      

      k localK = b.a(localN);
      localN.a("network-http-complete");
      


      if ((e) && (localN.v())) {
        localN.b("not-modified");
        localN.w();
        return;
      }
      

      localObject = localN.a(localK);
      localN.a("network-parse-complete");
      


      if ((localN.p()) && (b != null)) {
        c.a(localN.d(), b);
        localN.a("network-cache-written");
      }
      

      localN.u();
      d.a(localN, (p)localObject);
      localN.a((p)localObject);
    } catch (u localU) {
      localU.a(SystemClock.elapsedRealtime() - l);
      a(localN, localU);
      localN.w();
    } catch (Exception localException) {
      v.a(localException, "Unhandled exception %s", new Object[] { localException.toString() });
      Object localObject = new u(localException);
      ((u)localObject).a(SystemClock.elapsedRealtime() - l);
      d.a(localN, (u)localObject);
      localN.w();
    }
  }
  
  private void a(n<?> paramN, u paramU) {
    paramU = paramN.a(paramU);
    d.a(paramN, paramU);
  }
}
