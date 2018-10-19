package me.kiip.internal.a;

import android.content.Intent;























public class a
  extends u
{
  private Intent b;
  
  public a() {}
  
  public a(k paramK)
  {
    super(paramK);
  }
  












  public String getMessage()
  {
    if (b != null) {
      return "User needs to (re)enter credentials.";
    }
    return super.getMessage();
  }
}
