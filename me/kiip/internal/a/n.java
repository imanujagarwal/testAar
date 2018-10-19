package me.kiip.internal.a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

























































public abstract class n<T>
  implements Comparable<n<T>>
{
  private final v.a a = v.a.a ? new v.a() : null;
  


  private final int b;
  


  private final String c;
  


  private final int d;
  

  private final Object e = new Object();
  


  private p.a f;
  

  private Integer g;
  

  private o h;
  

  private boolean i = true;
  


  private boolean j = false;
  


  private boolean k = false;
  

  private boolean l = false;
  



  private r m;
  



  private b.a n = null;
  











  private a o;
  












  public n(int paramInt, String paramString, p.a paramA)
  {
    b = paramInt;
    c = paramString;
    f = paramA;
    a(new e());
    
    d = c(paramString);
  }
  


  public int a()
  {
    return b;
  }
  




























  public int b()
  {
    return d;
  }
  


  private static int c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      Uri localUri = Uri.parse(paramString);
      if (localUri != null) {
        String str = localUri.getHost();
        if (str != null) {
          return str.hashCode();
        }
      }
    }
    return 0;
  }
  




  public n<?> a(r paramR)
  {
    m = paramR;
    return this;
  }
  


  public void a(String paramString)
  {
    if (v.a.a) {
      a.a(paramString, Thread.currentThread().getId());
    }
  }
  




  void b(final String paramString)
  {
    if (h != null) {
      h.b(this);
    }
    if (v.a.a) {
      final long l1 = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper())
      {

        Handler localHandler = new Handler(Looper.getMainLooper());
        localHandler.post(new Runnable()
        {
          public void run() {
            n.b(n.this).a(paramString, l1);
            n.b(n.this).a(toString());
          }
        });
        return;
      }
      
      a.a(paramString, l1);
      a.a(toString());
    }
  }
  





  public n<?> a(o paramO)
  {
    h = paramO;
    return this;
  }
  




  public final n<?> a(int paramInt)
  {
    g = Integer.valueOf(paramInt);
    return this;
  }
  












  public String c()
  {
    return c;
  }
  


  public String d()
  {
    return c();
  }
  





  public n<?> a(b.a paramA)
  {
    n = paramA;
    return this;
  }
  


  public b.a e()
  {
    return n;
  }
  
























  public boolean f()
  {
    synchronized (e) {
      return j;
    }
  }
  




  public Map<String, String> g()
    throws a
  {
    return Collections.emptyMap();
  }
  









  @Deprecated
  protected Map<String, String> h()
    throws a
  {
    return l();
  }
  













  @Deprecated
  protected String i()
  {
    return m();
  }
  


  @Deprecated
  public String j()
  {
    return n();
  }
  









  @Deprecated
  public byte[] k()
    throws a
  {
    Map localMap = h();
    if ((localMap != null) && (localMap.size() > 0)) {
      return a(localMap, i());
    }
    return null;
  }
  






  protected Map<String, String> l()
    throws a
  {
    return null;
  }
  











  protected String m()
  {
    return "UTF-8";
  }
  


  public String n()
  {
    return "application/x-www-form-urlencoded; charset=" + m();
  }
  







  public byte[] o()
    throws a
  {
    Map localMap = l();
    if ((localMap != null) && (localMap.size() > 0)) {
      return a(localMap, m());
    }
    return null;
  }
  


  private byte[] a(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try {
      for (Map.Entry localEntry : paramMap.entrySet()) {
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getKey(), paramString));
        localStringBuilder.append('=');
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getValue(), paramString));
        localStringBuilder.append('&');
      }
      return localStringBuilder.toString().getBytes(paramString);
    } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
      throw new RuntimeException("Encoding not supported: " + paramString, localUnsupportedEncodingException);
    }
  }
  












  public final boolean p()
  {
    return i;
  }
  












  public final boolean q()
  {
    return l;
  }
  













  public b r()
  {
    return b.b;
  }
  




  public final int s()
  {
    return m.a();
  }
  


  public r t()
  {
    return m;
  }
  



  public void u()
  {
    synchronized (e) {
      k = true;
    }
  }
  


  public boolean v()
  {
    synchronized (e) {
      return k;
    }
  }
  








  protected abstract p<T> a(k paramK);
  







  protected u a(u paramU)
  {
    return paramU;
  }
  




  protected abstract void a(T paramT);
  




  public void b(u paramU)
  {
    p.a localA;
    



    synchronized (e) {
      localA = f;
    }
    if (localA != null) {
      localA.a(paramU);
    }
  }
  




  void a(a paramA)
  {
    synchronized (e) {
      o = paramA;
    }
  }
  


  void a(p<?> paramP)
  {
    a localA;
    

    synchronized (e) {
      localA = o;
    }
    if (localA != null) {
      localA.a(this, paramP);
    }
  }
  


  void w()
  {
    a localA;
    
    synchronized (e) {
      localA = o;
    }
    if (localA != null) {
      localA.a(this);
    }
  }
  




  public int a(n<T> paramN)
  {
    b localB1 = r();
    b localB2 = paramN.r();
    


    return localB1 == localB2 ? g
      .intValue() - g.intValue() : localB2
      .ordinal() - localB1.ordinal();
  }
  
  public String toString()
  {
    String str = "0x" + Integer.toHexString(b());
    return (j ? "[X] " : "[ ] ") + c() + " " + str + " " + 
      r() + " " + g;
  }
  
  public static enum b
  {
    private b() {}
  }
  
  static abstract interface a
  {
    public abstract void a(n<?> paramN, p<?> paramP);
    
    public abstract void a(n<?> paramN);
  }
}
