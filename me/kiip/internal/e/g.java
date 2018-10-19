package me.kiip.internal.e;

public class g extends Exception
{
  private int a;
  private String b;
  
  public g(int paramInt, String paramString1, String paramString2) {
    super(paramString1);
    a = paramInt;
    b = paramString2;
  }
  
  public int a() {
    return a;
  }
  
  public String b() {
    return b;
  }
}
