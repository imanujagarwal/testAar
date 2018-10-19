package me.kiip.internal.a;

import android.text.TextUtils;















public final class g
{
  private final String a;
  private final String b;
  
  public g(String paramString1, String paramString2)
  {
    a = paramString1;
    b = paramString2;
  }
  
  public final String a() {
    return a;
  }
  
  public final String b() {
    return b;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if ((o == null) || (getClass() != o.getClass())) { return false;
    }
    g localG = (g)o;
    
    return (TextUtils.equals(a, a)) && 
      (TextUtils.equals(b, b));
  }
  
  public int hashCode()
  {
    int i = a.hashCode();
    i = 31 * i + b.hashCode();
    return i;
  }
  
  public String toString()
  {
    return "Header[name=" + a + ",value=" + b + "]";
  }
}
