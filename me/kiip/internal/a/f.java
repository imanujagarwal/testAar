package me.kiip.internal.a;

import android.os.Handler;
import java.util.concurrent.Executor;
























public class f
  implements q
{
  private final Executor a;
  
  public f(final Handler paramHandler)
  {
    a = new Executor()
    {
      public void execute(Runnable command) {
        paramHandler.post(command);
      }
    };
  }
  









  public void a(n<?> paramN, p<?> paramP)
  {
    a(paramN, paramP, null);
  }
  
  public void a(n<?> paramN, p<?> paramP, Runnable paramRunnable)
  {
    paramN.u();
    paramN.a("post-response");
    a.execute(new a(paramN, paramP, paramRunnable));
  }
  
  public void a(n<?> paramN, u paramU)
  {
    paramN.a("post-error");
    p localP = p.a(paramU);
    a.execute(new a(paramN, localP, null));
  }
  

  private class a
    implements Runnable
  {
    private final n b;
    
    private final p c;
    private final Runnable d;
    
    public a(n paramN, p paramP, Runnable paramRunnable)
    {
      b = paramN;
      c = paramP;
      d = paramRunnable;
    }
    









    public void run()
    {
      if (b.f()) {
        b.b("canceled-at-delivery");
        return;
      }
      

      if (c.a()) {
        b.a(c.a);
      } else {
        b.b(c.c);
      }
      


      if (c.d) {
        b.a("intermediate-response");
      } else {
        b.b("done");
      }
      

      if (d != null) {
        d.run();
      }
    }
  }
}
