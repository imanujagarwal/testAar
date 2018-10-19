package me.kiip.internal.b;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import me.kiip.internal.a.g;























public final class h
{
  private final int a;
  private final List<g> b;
  private final int c;
  private final InputStream d;
  
  public h(int paramInt, List<g> paramList)
  {
    this(paramInt, paramList, -1, null);
  }
  









  public h(int paramInt1, List<g> paramList, int paramInt2, InputStream paramInputStream)
  {
    a = paramInt1;
    b = paramList;
    c = paramInt2;
    d = paramInputStream;
  }
  
  public final int a()
  {
    return a;
  }
  
  public final List<g> b()
  {
    return Collections.unmodifiableList(b);
  }
  
  public final int c()
  {
    return c;
  }
  



  public final InputStream d()
  {
    return d;
  }
}
