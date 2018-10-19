package me.kiip.internal.b;

import java.io.UnsupportedEncodingException;
import me.kiip.internal.a.k;
import me.kiip.internal.a.n;
import me.kiip.internal.a.p;
import me.kiip.internal.a.p.a;
import me.kiip.internal.a.p.b;
import me.kiip.internal.a.v;



























public abstract class m<T>
  extends n<T>
{
  private static final String a = String.format("application/json; charset=%s", new Object[] { "utf-8" });
  

  private final Object b = new Object();
  




  private p.b<T> c;
  




  private final String d;
  




  public m(int paramInt, String paramString1, String paramString2, p.b<T> paramB, p.a paramA)
  {
    super(paramInt, paramString1, paramA);
    c = paramB;
    d = paramString2;
  }
  




  protected void a(T paramT)
  {
    p.b localB;
    



    synchronized (b) {
      localB = c;
    }
    if (localB != null) {
      localB.a(paramT);
    }
  }
  


  protected abstract p<T> a(k paramK);
  


  @Deprecated
  public String j()
  {
    return n();
  }
  



  @Deprecated
  public byte[] k()
  {
    return o();
  }
  
  public String n()
  {
    return a;
  }
  
  public byte[] o()
  {
    try {
      return d == null ? null : d.getBytes("utf-8");
    } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
      v.d("Unsupported Encoding while trying to get the bytes of %s using %s", new Object[] { d, "utf-8" });
    }
    return null;
  }
}
