package me.kiip.internal.a;








public class e
  implements r
{
  private int a;
  






  private int b;
  






  private final int c;
  






  private final float d;
  







  public e()
  {
    this(2500, 1, 1.0F);
  }
  





  public e(int paramInt1, int paramInt2, float paramFloat)
  {
    a = paramInt1;
    c = paramInt2;
    d = paramFloat;
  }
  



  public int a()
  {
    return a;
  }
  



  public int b()
  {
    return b;
  }
  










  public void a(u paramU)
    throws u
  {
    b += 1;
    a = ((int)(a + a * d));
    if (!c()) {
      throw paramU;
    }
  }
  


  protected boolean c()
  {
    return b <= c;
  }
}
